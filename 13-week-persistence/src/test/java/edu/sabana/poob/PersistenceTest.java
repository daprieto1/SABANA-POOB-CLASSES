package edu.sabana.poob;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.UUID;

public class PersistenceTest {

    @Test
    public void shouldWriteObject() throws IOException {
        Student s = new Student(UUID.randomUUID(), "Juan");
        System.out.println("s = " + s);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.out"));
        out.writeObject("Student info \n");
        out.writeObject(s);
        out.close();
    }

    @Test
    public void shouldReadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.out"));
        String message = (String) in.readObject();
        Student s = (Student) in.readObject();
        System.out.println(message + " s = " + s);
        in.close();
    }

    @Test
    public void shouldWriteText() throws IOException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("text.txt"));

        for (int i = 0; i < 5; i++) {
            pw.println("This is a new line " + i);
        }
        pw.close();
    }

    @Test
    public void shouldReadText() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));

        String line = br.readLine();
        while (line != null) {
            System.out.println(line.trim());
            line = br.readLine();
        }

        br.close();
    }


    @Test
    public void shouldRedirect() throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("text.txt"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }

}
