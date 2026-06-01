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

    private final Scanner scanner;
    private final ConsolaCredencialesProveedor credenciales;
    private final Menu menu;
    private final Login login;
    private final Usuario cajero;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.credenciales = new ConsolaCredencialesProveedor(scanner);
        this.menu = new Menu();
        this.login = new Login();
        this.cajero = new Usuario("cajero1", "Supersena");
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.iniciar();
    }

    public void iniciar() {
        imprimirTitulo();

        if (ejecutarLogin()) {
            ejecutarCicloMenu();
        }

        scanner.close();
    }

    private boolean ejecutarLogin() {
        while (true) {
            try {
                String usuarioIngresado = credenciales.obtenerUsuario();
                String contrasenaIngresada = credenciales.obtenerContrasena();

                if (login.autenticar(cajero, usuarioIngresado, contrasenaIngresada)) {
                    System.out.println("¡Inicio de sesión exitoso!\n");
                    return true;
                } else {
                    System.out.println("❌ Error: Credenciales inválidas. Intente de nuevo.\n");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error crítico en el sistema de login", e);
                return false;
            }
        }
    }

    private void ejecutarCicloMenu() {
        boolean corriendo = true;
        while (corriendo) {
            int opcion = menu.imprimirMenu(scanner);

            switch (opcion) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    System.out.println("\n🎟️ ¡Boleto comprado con éxito!");
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    corriendo = false;
                    break;
                default:
                    System.out.println("❌ Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private void mostrarPeliculas() {
        System.out.println("\n--- Películas Disponibles ---");
        System.out.println("- Terminator: La rebelión de las máquinas");
        System.out.println("- ¡Para o mi mamá dispara!");
        System.out.println("- Mi pobre angelito");
    }

    private static void imprimirTitulo() {
        System.out.println("=====================");
        System.out.println("    Proyecto Final   ");
        System.out.println("=====================");
    }
}