package net.salesianos.actividad1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        String fileRoute = "src/net/salesianos/actividad1/fichero/actividad1.txt";
        saveFormattedText(fileRoute);
    }

    public static void saveFormattedText(String fileRoute) {
        Scanner tb = new Scanner(System.in);
        String text;

        while (true) {
            System.out.println("Introduzca un texto de al menos 30 caracteres:");
            text = tb.nextLine();

            if (text.length() >= 30) {
                break;
            } else {
                System.out.printf("Te faltaron %d caracteres.%n", 30 - text.length());
            }
        }

        text = text.toUpperCase().replace(" ", "_");

        try (FileWriter textFileWriter = new FileWriter(fileRoute)) {
            textFileWriter.write(text);
            System.out.println("Texto guardado correctamente.");
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }
        tb.close();
    }
}
