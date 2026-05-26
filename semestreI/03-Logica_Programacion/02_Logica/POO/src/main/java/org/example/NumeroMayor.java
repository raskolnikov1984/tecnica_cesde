package org.example;

import java.util.Arrays;

public class NumeroMayor {

    /*
    * Metodo para hallar el mayor de dos numeros enteros.
    */
    public int calcularMayor(int numero_uno, int numero_dos){
        // * TTernary operator
        // * (numero_uno > numero_dos) ? numero_uno : numero_dos;

        return Math.max(numero_uno, numero_dos);
    }

    public static void main(String[] args){

        if(args.length == 0){
            System.out.println("Por favor, introduce una lista de números separados por espacios.");
            return;
        }

        NumeroMayor mayor = new NumeroMayor();

        int numero_mayor = Integer.MIN_VALUE;

        for (String arg : args) {
            try {
                int n = Integer.parseInt(arg);
                numero_mayor = mayor.calcularMayor(numero_mayor, n);
            }
            catch (NumberFormatException e) {
                /* pass */
            }
        }

        System.out.println("El número mayor es: " + numero_mayor);
    }
}
