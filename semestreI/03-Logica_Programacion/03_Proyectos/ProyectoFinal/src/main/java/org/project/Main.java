package org.project;

import org.project.logic.ConsolaCredencialesProveedor;
import org.project.logic.Usuario;
import org.project.logic.Login;

import java.util.logging.Logger;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static void main() {
        logger.info("=====================");
        logger.info("    Proyecto Final   ");
        logger.info("=====================");

        Scanner scanner = new Scanner(System.in);
        ConsolaCredencialesProveedor credenciales = new ConsolaCredencialesProveedor(scanner);
        Usuario cajero = new Usuario("cajero1", "Supersena");
        Login login = new Login();

        try {
            String usuarioIngresado = credenciales.obtenerUsuario();
            String contrasenaIngresada = credenciales.obtenerContrasena();

            boolean exito = login.autenticar(cajero, usuarioIngresado, contrasenaIngresada);

            if (exito) {
                logger.info("¡Inicio de sesión exitoso!");
            } else {
                logger.info("Error: Credenciales inválidas.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
