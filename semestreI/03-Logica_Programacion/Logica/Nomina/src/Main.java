import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de la hora: ");
        float valorHora = scanner.nextFloat();

        System.out.println("Ingrese el numero de horas laboradas: ");
        float horasLaboradas = scanner.nextFloat();
        float salarioBasico;


        salarioBasico = valorHora * horasLaboradas;

        System.out.printf("El Salario Basico es: %.2f%n", salarioBasico);
        scanner.close();
    }
}