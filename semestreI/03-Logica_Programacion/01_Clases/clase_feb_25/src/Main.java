import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        print_class_tittle();
        // calculate_payroll();
        calculate_semester_cost();
    }

    static void print_class_tittle() {
        System.out.println("------------------------------------");
        System.out.println("Clase Febrero 25 2026");
        System.out.println("------------------------------------");
    }

    static void calculate_payroll(){
        float numHours, valHour, numTan, dedMonthly;

        numHours = 150;
        valHour = 12300;
        numTan = 2;
        dedMonthly = 13000;

        float salBruto;
        float valBonification;
        float salNeto;

        salBruto = numHours * valHour;
        valBonification = 30000 * numTan;
        salNeto = salBruto - dedMonthly + valBonification;

        System.out.println("El Salario basico del empleado es: " + salBruto);
        System.out.println("Valor de la bonificacion es: " + valBonification);
        System.out.println("Las deducciones son: " + dedMonthly);
        System.out.println("El Salario neto es: " + salNeto);
    }

    static void calculate_semester_cost(){
        Scanner scanner = new Scanner(System.in);

        String student_name;
        int numClasses = 0;

        float costByClass = 200000;
        float semesterCost;

        System.out.println("Ingrese el nombre del estudiante: ");
        student_name = scanner.next();

        while(numClasses < 0 || numClasses == 0){
            System.out.println("Ingrese la cantidad de materias a matricular: ");
            numClasses = scanner.nextInt();
        }

        semesterCost = costByClass * numClasses;
        System.out.println("El Valor del semestre de" + student_name + "es: " + semesterCost);



    }
}