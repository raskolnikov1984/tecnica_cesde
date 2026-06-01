package org.project.logic;

import java.util.Scanner;

public class ConsolaCredencialesProveedor implements CredencialesProveedor{
    private final Scanner scanner;

    public ConsolaCredencialesProveedor(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String obtenerUsuario(){
        System.out.print("Ingrese su usuario: ");
        return scanner.nextLine();
    }

    @Override
    public String obtenerContrasena() {
        System.out.print("Ingrese su contrasena: ");
        return scanner.nextLine();
    }
}
