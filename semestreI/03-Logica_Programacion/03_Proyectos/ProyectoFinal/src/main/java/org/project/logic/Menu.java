package org.project.logic;
import org.project.Main;

import java.util.Scanner;
import java.util.logging.Logger;

public class Menu {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static int opciones = 3;

    public int imprimirMenu(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n==========  Menu  ============");
            System.out.println("1. Ver Peliculas Disponibles.  ");
            System.out.println("2. Comprar Boleto.            ");
            System.out.println("3. Salir.                     ");
            System.out.println("==============================");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (!esUnaOpcionValida(opcion)) {
                System.out.println("⚠️ Opción inválida. Intente de nuevo.");
            }

        } while (!esUnaOpcionValida(opcion));

        return opcion;
    }
    private static boolean esUnaOpcionValida(int opcion){
        return opcion>=1 && opcion <= opciones;
    }
}
