package org.example;

public class FinalWorkout {

    public static int calculateManualPow (int firstNumber, int secondNumber) {
        /*
        * Elaborar una solución que lea dos números y luego mediante sumas
        * encuentre el resultado de multiplicar el primero por el segundo.
        * */
        int result = firstNumber;

        if (secondNumber != 0){
            for(int i = 0; i < secondNumber; i++){
                result += firstNumber;
            }
        } else {
            return 1;
        }

        return result;
    }

    public static int calculateFactorial(int number){
        int result = number;
        for(int i = number - 1 ; i > 0; i--){
            result *= i;
        }

        return result;
    }

    /**
     * Método que imprime los primeros N números primos.
     */
    public static void printFirstNPrimes(int n) {
        if (n <= 0) {
            System.out.println("Por favor, ingresa un número mayor a 0.");
            return;
        }

        int primesFound = 0; // Contador de primos encontrados
        int currentNumber = 2; // El primer número primo posible

        System.out.println("The first " + n + " prime numbers are: ");

        while (primesFound < n) {
            if (isPrime(currentNumber)) {
                System.out.print(currentNumber + " ");
                primesFound++;
            }
            currentNumber++;
        }
        System.out.println();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
