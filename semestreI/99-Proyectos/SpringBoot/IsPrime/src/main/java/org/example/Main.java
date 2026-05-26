package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a positive number: ");
        int number = scanner.nextInt();

        if(isPrime(number)){
            System.out.println("Is prime");
        } else {
            System.out.println("Not is prime");
        }
    }

    public static boolean isPrime(int number){
        if (number < 0){
            System.out.println("Must be a positive number." + number);
        };

        if (number == 1 || number == 2){
            return true;
        } else if (number % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(number); i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
        };

        return true;
    }
}