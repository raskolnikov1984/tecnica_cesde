import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main forLoops = new Main();

        System.out.println("Seleccione un ejercicio: ");
        int option = forLoops.scanner.nextInt();

        switch (option){
            case 1:
                forLoops.print_n_term();
                break;
            case 2:
                forLoops.print_n_workers();
                break;
            default:
                break;
        }
    }

    public void print_n_term() {
        /*
         * i1 = 4  1
         * i2 = 8  2
         * i3 = 12 3
         * i4 = 16 4
         * i5 = 20 5
         * i6 = 24 6
         */

        System.out.printf("Cual es el N-esimo termino que desea: ");
        int termino_n = this.scanner.nextInt();
        int seed_number = 4;

        for (int i = 1; i <= termino_n; i++) {
            System.out.println(seed_number * i);
        }

        this.scanner.close();
    }

    public void print_n_workers() {
        ArrayList<Map<String, Object>> listaTrabajadores = getMapArrayList();

        System.out.println("--- Listado de Trabajadores ---");
        for (Map<String, Object> t : listaTrabajadores) {
            String nombre = (String) t.get("nombre");
            double sHora = (double) t.get("salarioBasicoHora");
            int horas = (int) t.get("horasTrabajadas");
            double bonif = (double) t.get("bonificaciones");
            double deduc = (double) t.get("deducciones");

            double salarioBruto = (sHora * horas) + bonif;
            double salarioNeto = salarioBruto - deduc;

            System.out.printf("Nombre: %s | Bruto: %.2f | Neto: %.2f%n",
                    nombre, salarioBruto, salarioNeto);
        }
    }

    private static ArrayList<Map<String, Object>> getMapArrayList() {
        ArrayList<Map<String, Object>> listaTrabajadores = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Map<String, Object> trabajador = new HashMap<>();

            // Adding the structure to each map
            trabajador.put("nombre", "Trabajador " + i);
            trabajador.put("salarioBasicoHora", 15.0);
            trabajador.put("horasTrabajadas", 40);
            trabajador.put("deducciones", 50.0);
            trabajador.put("bonificaciones", 100.0);

            listaTrabajadores.add(trabajador);
        }
        return listaTrabajadores;
    }
}