package net.salesianos.actividad4;

import java.util.List;
import java.util.Scanner;

import net.salesianos.actividad4.clases.Manager;
import net.salesianos.actividad4.clases.Table;

public class Actividad4 {
    public static void main(String[] args) {
        Scanner tb = new Scanner(System.in);
        String fileRoute = "src/net/salesianos/actividad4/fichero/Actividad4.txt";
        List<Table> mesas = Manager.getTables(fileRoute);

        while (true) {
            System.out.println("\n*********************Menú*********************");
            System.out.println("1. Nueva mesa");
            System.out.println("2. Mostrar todas las mesas almacenadas");
            System.out.println("3. Salir");
            System.out.print("Escriba la elección: ");

            int option = tb.nextInt();
            tb.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Introduzca el color de la mesa: ");
                    String color = tb.nextLine();

                    System.out.print("Introduzca el número de patas: ");
                    int numeroPatas = tb.nextInt();

                    Table newMesa = new Table(color, numeroPatas);
                    Manager.saveTable(mesas, newMesa, fileRoute);
                    break;

                case 2:
                    // List<Mesa> mesass = Manager.getMesas(fileRoute);
                    // Manager.getMesas(fileRoute);
                    for (Table mesa : Manager.getTables(fileRoute)) {
                        System.out.println(mesa);
                    }
                    break;

                case 3:
                    tb.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
