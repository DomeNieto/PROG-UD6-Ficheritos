package net.salesianos.actividad2;

import java.io.FileReader;
import java.io.IOException;

public class Actividad2 {

    public static void main(String[] args) {

        String fileRoute = "src/net/salesianos/actividad2/fichero2/Actividad2.txt";
        readAndDisplayText(fileRoute);
    }

    public static void readAndDisplayText(String fileRoute) {
        try (FileReader reader = new FileReader(fileRoute)) {
            int nextChar = reader.read();

            while (nextChar != -1) {
                char character = (char) nextChar;
                System.out.printf("%c_%d, ", character, nextChar);
                nextChar = reader.read();

            }

        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O al leer el archivo.");
        }
    }
}