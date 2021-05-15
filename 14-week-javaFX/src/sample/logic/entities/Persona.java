package sample.logic.entities;

import sample.logic.PersonaException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Persona extends Exportable implements Serializable {

    //private UUID id;
    private String name;
    private String lastName;
    private int age;

    public Persona(String name, String lastName, String age) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        // this.id = UUID.randomUUID();
        this.setAge(age);
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(String ageInput) throws PersonaException {
        try {
            int age = Integer.parseInt(ageInput);

            if (age < 0) throw new PersonaException(PersonaException.BAD_AGE_LOWER);
            if (age > 120) throw new PersonaException(PersonaException.BAD_AGE_UPPER);

            this.age = age;
        } catch (NumberFormatException er) {
            throw new PersonaException(PersonaException.BAD_AGE + " : " + er.getMessage());
        }
    }

    public String getAge() {
        return "The age is " + this.age;
    }


    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        return result;
    }

    @Override
    public String getHeader() {

        return "name,LastName,";
    }
}
