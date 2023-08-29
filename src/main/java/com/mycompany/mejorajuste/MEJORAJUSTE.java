package com.mycompany.mejorajuste;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MEJORAJUSTE {
    public static void main(String[] args) {
        int memoriaTotal = 2000;
        int memoriaUtilizada = 200;
        Scanner scanner = new Scanner(System.in);

        List<PARTICION> particiones = new ArrayList<>();
        List<PROCESO> procesos = new ArrayList<>();

        System.out.print("Ingrese el número de particiones adicionales: ");
        int numParticiones = scanner.nextInt();

        for (int i = 0; i < numParticiones; i++) {
            System.out.print("Ingrese el tamaño de la partición " + (i + 1) + ": ");
            int tamanoParticion = scanner.nextInt();
            particiones.add(new PARTICION("Partición " + (i + 1), tamanoParticion));
        }

        procesos.add(new PROCESO("java", 70));
        procesos.add(new PROCESO("word", 200));
        procesos.add(new PROCESO("paint", 10));
        procesos.add(new PROCESO("SQL", 20));
        procesos.add(new PROCESO("A", 250));

        for (PROCESO proceso : procesos) {
            boolean asignado = false;
            PARTICION bestFitParticion = null;

            for (PARTICION particion : particiones) {
                if (!particion.ocupada && particion.tamano >= proceso.tamano) {
                    if (bestFitParticion == null || particion.tamano < bestFitParticion.tamano) {
                        bestFitParticion = particion;
                    }
                }
            }

            if (bestFitParticion != null) {
                asignado = true;
                bestFitParticion.ocupada = true;
                bestFitParticion.nombreProceso = proceso.nombre;
                System.out.println(proceso.nombre + " asignado a la partición " + bestFitParticion.nombre);
                memoriaUtilizada += proceso.tamano;
            }

            if (!asignado) {
                System.out.println(proceso.nombre + " no pudo ser asignado a la memoria");
            }

            int memoriaRestante = memoriaTotal - memoriaUtilizada;
            if (memoriaRestante > 0) {
                particiones.add(new PARTICION("Partición " + (particiones.size() + 1), memoriaRestante));
            }
        }

        int memoriaDisponible = memoriaTotal - memoriaUtilizada;
        if (memoriaDisponible < 0) {
            memoriaDisponible = 0;
        }

        System.out.println("Memoria disponible: " + memoriaDisponible);

        scanner.close();
    }
}