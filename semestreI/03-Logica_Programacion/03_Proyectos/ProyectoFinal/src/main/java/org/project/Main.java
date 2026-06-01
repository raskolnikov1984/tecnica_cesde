package org.project;

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
        Usuario cajero = new Usuario("cajero1", "Supersena");
        Login login = new Login();

        try {
            System.out.print("Ingrese su usuario: ");
            String usuarioIngresado = scanner.next();

            System.out.print("Ingrese su contraseña: ");
            String contrasenaIngresada = scanner.next();

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
