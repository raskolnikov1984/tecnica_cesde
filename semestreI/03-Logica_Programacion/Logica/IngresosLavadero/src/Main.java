import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadTaxis, cantidadBuses, cantidadParticulares, cantidadMotos;

        final int valorTaxis = 30000;
        final int valorBuses = 80000;
        final int valorParticulares = 40000;
        final int valorMotos = 15000;

        int totalDia = 0;

        System.out.print("Ingrese la cantidad de Taxis: ");
        cantidadTaxis = scanner.nextInt();

        if(cantidadTaxis > 0){
            totalDia += (cantidadTaxis * valorTaxis);
       ; }

        System.out.print("Ingrese la cantidad de Buses: ");
        cantidadBuses = scanner.nextInt();

        if(cantidadBuses > 0){
            totalDia += (cantidadBuses * valorBuses);
        }

        System.out.print("Ingrese la cantidad de Particulares: ");
        cantidadParticulares = scanner.nextInt();

        if(cantidadParticulares > 0){
            totalDia += (cantidadParticulares * valorParticulares);
        }

        System.out.print("Ingrese la cantidad de Motos: ");
        cantidadMotos = scanner.nextInt();

        if(cantidadMotos > 0){
            totalDia += (cantidadMotos * valorMotos);
        }

        System.out.print("El valor recolectado en el Dia es: " + totalDia);




    }
}