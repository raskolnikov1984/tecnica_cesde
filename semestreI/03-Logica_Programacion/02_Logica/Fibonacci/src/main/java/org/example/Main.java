package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Imprima el N-esimo Termino");
        Scanner scanner = new Scanner(System.in);

        int n_termino = scanner.nextInt();

        calculate_n_fibonacci_number(n_termino);
    }

    public static void calculate_n_fibonacci_number(int n){
        int a = 0;
        int b = 1;
        int c = 0;

        System.out.println("El terminio " + 1 + " es: " + a);
        System.out.println("El terminio " + 2 + " es: " + b);

        for(int i=3; i<= n; i++){
            c = b + a;
            a = b;
            b = c;

            System.out.println("El terminio " + i + " es: " + c);
        }
    }
}