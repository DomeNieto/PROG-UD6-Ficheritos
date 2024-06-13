package net.salesianos.actividad4.clases;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static void saveTable(List<Table> tables, Table table, String fileRoute) {

        tables.add(table);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileRoute))) {
            for (Table t : tables) {
                oos.writeObject(t);
            }
            System.out.println("Mesa guardada correctamente.");
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O.");
        }

    }

    public static List<Table> getTables(String fileRoute) {

        List<Table> tables = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileRoute))) {
            while (true) {
                try {
                    Table table = (Table) ois.readObject();
                    tables.add(table);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: Problema de I/O ");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Clase no encontrada.");
        }

        return tables;

    }
}
