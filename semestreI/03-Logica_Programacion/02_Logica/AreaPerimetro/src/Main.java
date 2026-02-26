import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la base del cuadrado: ");
        int lado = scanner.nextInt();
        int perimetro, area;

        perimetro = lado * 4;
        area = lado * lado;

        System.out.println("El Area del cuadrado es: " + area);
        System.out.println("El Perimetro del cuadrado es: " + perimetro);
    }
}