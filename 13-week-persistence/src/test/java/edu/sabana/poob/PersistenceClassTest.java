package edu.sabana.poob;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.UUID;

public class PersistenceClassTest {

    @Test
    public void shouldWriteTextInFile() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("class-example.doc");
        PrintWriter pw = new PrintWriter(fos);

        for (int i = 0; i < 10; i++) {
            //pw.println("This is line number " + i);
            pw.println(new Student(UUID.randomUUID(), "Juan"));
        }

        pw.close();
    }

    @Test
    public void shouldReadTextInFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("class-example.sabana"));

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }

        br.close();
    }

    @Test
    public void shouldWriteObjectsInFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.sabana"));

        for (int i = 0; i < 10; i++) {
            out.writeObject("This is student " + (i + 1));
            out.writeObject(new Student(UUID.randomUUID(), "Maria"));
        }

        out.close();

    }

    @Test
    public void shouldReadObjectsInFile() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.sabana"));

        Student message = (Student) in.readObject();
        Student s1 = (Student) in.readObject();

        in.close();

    }

}
