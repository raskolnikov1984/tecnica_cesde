package org.project;

import org.project.logic.ConsolaCredencialesProveedor;
import org.project.logic.Menu;
import org.project.logic.Usuario;
import org.project.logic.Login;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static void main() {
        System.out.println("=====================");
        System.out.println("    Proyecto Final   ");
        System.out.println("=====================");

        Scanner scanner = new Scanner(System.in);
        ConsolaCredencialesProveedor credenciales = new ConsolaCredencialesProveedor(scanner);
        Menu menu = new Menu();

        Usuario cajero = new Usuario("cajero1", "Supersena");
        Login login = new Login();

        boolean autenticado = false;
        while (!autenticado) {
            try {
                String usuarioIngresado = credenciales.obtenerUsuario();
                String contrasenaIngresada = credenciales.obtenerContrasena();

                autenticado = login.autenticar(cajero, usuarioIngresado, contrasenaIngresada);

                if (autenticado) {
                    System.out.println("¡Inicio de sesión exitoso!\n");
                } else {
                    System.out.println("❌ Error: Credenciales inválidas. Intente de nuevo.");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error crítico en el sistema de login", e);
                return;
            }
        }

        boolean corriendo = true;
        while (corriendo) {
            int opcion = menu.imprimirMenu(scanner);

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Películas Disponibles ---");
                    System.out.println("- Terminator: La rebelión de las máquinas");
                    System.out.println("- ¡Para o mi mamá dispara!");
                    System.out.println("- Mi pobre angelito");
                    break;
                case 2:
                    System.out.println("\n🎟️ ¡Boleto comprado con éxito!");
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    corriendo = false;
                    break;
                default:
                    System.out.println("Error inesperado.");
                    break;
            }
        }

        scanner.close();
    }
}