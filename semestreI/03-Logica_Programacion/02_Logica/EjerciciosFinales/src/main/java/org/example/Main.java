package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int exercise, result = 0;
        int number = 0;

        do {
            System.out.println("Choose a especific exercise (1 - 4): ");
            exercise = scanner.nextInt();
        } while (exercise == 0);

        switch (exercise) {
            case 1:

                int firstNumber = 0;
                int secondNumber = 0;

                System.out.println("Insert the first number");
                firstNumber = scanner.nextInt();

                System.out.println("Insert the second number");
                secondNumber = scanner.nextInt();

                result = FinalWorkout.calculateManualPow(
                        firstNumber,
                        secondNumber
                );

                System.out.println("First Number " + firstNumber + " pow " + secondNumber + " is " + result);
                break;
            case 2:
                System.out.println("Insert the number");
                number = scanner.nextInt();

                result = FinalWorkout.calculateFactorial(number);

                System.out.println(
                        "The factorial of " + number + " is " + result
                );
                break;
            case 3:
                System.out.println("Insert the number");
                number = scanner.nextInt();

                FinalWorkout.printFirstNPrimes(number);
                break;
            case 4:
                DrinkSurvey.main(new String[0]);
                break;
            default:
                System.out.println("Trying Again");
        }
    }
}