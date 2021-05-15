package sample.logic.persistence.impl;

import sample.logic.entities.Persona;
import sample.logic.persistence.IPersonaPersistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaPersistence implements IPersonaPersistence {

    private static final String PERSONAS_FILE_PATH = "personas.sabana";

    public PersonaPersistence() throws IOException {
        File file = new File(PERSONAS_FILE_PATH);
        if (file.createNewFile()) {
            System.out.println("The file " + file.getName() + " was created");
        }
    }

    @Override
    public void save(Persona persona) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(PERSONAS_FILE_PATH, true);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(persona);
        out.close();
    }

    @Override
    public List<Persona> read() throws IOException, ClassNotFoundException {

        List<Persona> result = new ArrayList<>();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(PERSONAS_FILE_PATH));


        try {
            while (true) {
                result.add((Persona) in.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Reached end of file");
        } finally {
            in.close();
        }

        return result;
    }

    @Override
    public void export() throws IOException {

    }
}
