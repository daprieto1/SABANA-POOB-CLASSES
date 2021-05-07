package edu.sabana.poob;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Student implements Serializable {

    private UUID id;
    private String name;
    private LocalDate birthdate;

    public Student(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.birthdate = LocalDate.now();
    }

    @Override
    public String toString() {
        return id.toString() + "," + name + "s," + birthdate.toString();
    }


}
