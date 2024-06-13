package net.salesianos.actividad3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Actividad3 {
    public static void main(String[] args) {
        String file1 = "src/net/salesianos/actividad1/fichero/actividad1.txt";
        String file2 = "src/net/salesianos/actividad2/fichero2/Actividad2.txt";
        String outputFile = "src/net/salesianos/actividad3/fichero/Actividad3.txt";
        mergeFiles(file1, file2, outputFile);
    }

    public static void mergeFiles(String file1, String file2, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            writer.write("Contenido del Fichero Uno:\n");
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
            }

            writer.write("\nContenido del Fichero Dos:\n");
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
            }

            writer.write("Firma: Hecho por Dome y Ori.");
            System.out.println("Ficheros fusionados correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }
    }
}
