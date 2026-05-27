package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkSurvey {

    static class Person {
        private String id;
        private char gender; // 'M' for Male, 'F' for Female
        private int age;
        private String preferredBeverage;
        private String city;

        public Person(String id, char gender, int age, String preferredBeverage, String city) {
            this.id = id;
            this.gender = Character.toUpperCase(gender);
            this.age = age;

            this.preferredBeverage = preferredBeverage.trim().toLowerCase();
            this.city = city.trim().toLowerCase();
        }


        public String getId() { return id; }
        public char getGender() { return gender; }
        public int getAge() { return age; }
        public String getPreferredBeverage() { return preferredBeverage; }
        public String getCity() { return city; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        System.out.println("--- SURVEY REGISTRATION ---");

        while (true) {
            System.out.print("Enter ID (or type 'end' to finish): ");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Enter Gender (M/F): ");
            char gender = scanner.nextLine().charAt(0);

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Preferred Beverage (Coca Cola, Pepsi, Manzana, Colombiana, etc.): ");
            String beverage = scanner.nextLine();

            System.out.print("Enter City of residence: ");
            String city = scanner.nextLine();

            personList.add(new Person(id, gender, age, beverage, city));
            System.out.println("Person successfully registered.\n---------------------------");
        }

        if (!personList.isEmpty()) {
            processSurveyData(personList);
        } else {
            System.out.println("No data was recorded in the survey.");
        }

        scanner.close();
    }

    public static void processSurveyData(List<Person> people) {

        int medellinCocaColaCount = 0;
        List<String> caliPepsiAdultMales = new ArrayList<>();
        int totalSurveyed = people.size();
        int bogotaManzanaCount = 0;

        int cartagenaColombianaFemalesAgeSum = 0;
        int cartagenaColombianaFemalesCount = 0;

        for (Person p : people) {

            // 1. Medellin and Coca Cola
            if (p.getCity().equals("medellin") && p.getPreferredBeverage().equals("coca cola")) {
                medellinCocaColaCount++;
            }

            // 2. Adult males (Age >= 18) who drink Pepsi and live in Cali
            if (p.getGender() == 'M' && p.getAge() >= 18
                    && p.getPreferredBeverage().equals("pepsi") && p.getCity().equals("cali")) {
                caliPepsiAdultMales.add(p.getId());
            }

            // 4. Manzana and Bogota
            if (p.getPreferredBeverage().equals("manzana") && p.getCity().equals("bogota")) {
                bogotaManzanaCount++;
            }

            // 5. Females who drink Colombiana and live in Cartagena (for the average age)
            if (p.getGender() == 'F' && p.getPreferredBeverage().equals("colombiana")
                    && p.getCity().equals("cartagena")) {
                cartagenaColombianaFemalesAgeSum += p.getAge();
                cartagenaColombianaFemalesCount++;
            }
        }

        // Calculate percentages and averages
        double bogotaManzanaPercentage = ((double) bogotaManzanaCount / totalSurveyed) * 100;

        double cartagenaFemalesAverageAge = 0;
        if (cartagenaColombianaFemalesCount > 0) {
            cartagenaFemalesAverageAge = (double) cartagenaColombianaFemalesAgeSum / cartagenaColombianaFemalesCount;
        }

        // --- PRINTING RESULTS ---
        System.out.println("\n==================================================");
        System.out.println("                 SURVEY RESULTS                   ");
        System.out.println("==================================================");

        System.out.println("1. Number of people living in Medellin who drink Coca Cola: " + medellinCocaColaCount);

        System.out.println("2. IDs of adult males living in Cali who drink Pepsi:");
        if (caliPepsiAdultMales.isEmpty()) {
            System.out.println("   - None match the criteria.");
        } else {
            for (String id : caliPepsiAdultMales) {
                System.out.println("   - ID: " + id);
            }
        }

        System.out.println("3. Total number of people surveyed: " + totalSurveyed);

        System.out.printf("4. Percentage of people who drink Manzana in Bogota relative to total: %.2f%%\n", bogotaManzanaPercentage);

        if (cartagenaColombianaFemalesCount > 0) {
            System.out.printf("5. Average age of females in Cartagena who drink Colombiana: %.1f years old\n", cartagenaFemalesAverageAge);
        } else {
            System.out.println("5. Average age of females in Cartagena who drink Colombiana: No records matched these criteria.");
        }
        System.out.println("==================================================");
    }
}