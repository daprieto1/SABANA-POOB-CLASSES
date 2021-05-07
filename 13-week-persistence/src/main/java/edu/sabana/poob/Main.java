package edu.sabana.poob;

import java.io.*;
import java.util.UUID;

public class Main {



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null && line.length() != 0) {
            System.out.println(line);
        }
    }

}
