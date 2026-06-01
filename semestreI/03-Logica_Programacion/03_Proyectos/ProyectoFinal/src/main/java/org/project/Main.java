package org.project;

import org.project.logic.ConsolaCredencialesProveedor;
import org.project.logic.Usuario;
import org.project.logic.Login;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        System.out.println("=====================");
        System.out.println("    Proyecto Final   ");
        System.out.println("=====================");

        Scanner scanner = new Scanner(System.in);
        ConsolaCredencialesProveedor credenciales = new ConsolaCredencialesProveedor(scanner);
        Usuario cajero = new Usuario("cajero1", "Supersena");
        Login login = new Login();

        try {
            String usuarioIngresado = credenciales.obtenerUsuario();
            String contrasenaIngresada = credenciales.obtenerContrasena();

            boolean exito = login.autenticar(cajero, usuarioIngresado, contrasenaIngresada);

            if (exito) {
                System.out.println("¡Inicio de sesión exitoso!");
            } else {
                System.out.println("Error: Credenciales inválidas.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
