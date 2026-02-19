import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float salario_mensual, ingresos_extra, gastos_mensuales, disponible, ahorro_anual;

        System.out.print("Ingrese el salario mensual: ");
        salario_mensual = scanner.nextFloat();

        System.out.print("Ingrese el monto de sus ingresos extra mensuales: ");
        ingresos_extra = scanner.nextFloat();

        System.out.print("Ingrese el monto de sus gastos mensuales: ");
        gastos_mensuales = scanner.nextFloat();

        disponible = salario_mensual + ingresos_extra - gastos_mensuales;

        ahorro_anual = disponible * 12;

        if(ahorro_anual > 0){
            System.out.print("Su ahorro anual es:" + ahorro_anual);
        } else {
            System.out.print("Usted No esta en condiciones de ahorrar");
        }

        scanner.close();
    }
}