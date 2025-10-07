package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
    //Estudiantes para testeo
        students.add(new Student("Rubén", 16, 6.5f, true));
        students.add(new Student("Maricarmen", 14, 8.1f, true));
        students.add(new Student("Josué", 14, 9.2f, true));
        students.add(new Student("Pedro Pablo", 18, 4.8f, true));

        System.out.println("=== SISTEMA DE GESTIÓN DE ESTUDIANTES ===");

        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Seleccione una opción: ");

            switch (choice) {
                case 1: addStudent();
                break;
                case 2: listStudents();
                System.out.println("\nPulsa Intro para continuar");
                sc.nextLine();
                break;
                case 3: searchByName();
                System.out.println("\nPulsa Intro para continuar");
                sc.nextLine();
                break;
                case 4: showAverageGrade();
                System.out.println("\nPulsa Intro para continuar");
                sc.nextLine();
                break;
                case 5: showTopStudent();
                System.out.println("\nPulsa Intro para continuar");
                sc.nextLine();
                break;
                case 6:
                System.out.println("Saliendo del programa.");
                running = false;
                sc.close();

                break;
                default: System.out.println("Opción no válida. Inténtalo nuevamente.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar nuevo estudiante");
        System.out.println("2. Listar todos los estudiantes");
        System.out.println("3. Buscar estudiante por nombre");
        System.out.println("4. Calcular nota media general");
        System.out.println("5. Mostrar mejor estudiante");
        System.out.println("6. Salir");
    }

    private static void addStudent() {


        String name;
        int age;
        float avg;

        System.out.println("\n--- AÑADIR ESTUDIANTE ---");

        do {
            System.out.print("Nombre: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (name.isEmpty());

        do {
            age = readInt("Edad: ");
            if (age < 0 || age > 18) {
                System.out.println("Edad no válida. Debe estar entre 0 y 18.");
            }
        } while (age < 0 || age > 18);

        do {
            avg = readFloat("Nota media (1 a 10): ");
            if (avg < 1 || avg > 10) {
                System.out.println("Nota no válida. Debe estar entre 1 y 10.");
            }
        } while (avg < 1 || avg > 10);

        boolean enrolled = askEnrollmentStatus();

        students.add(new Student(name, age, avg, enrolled));
        System.out.println("Estudiante añadido correctamente.");
    }



    private static void listStudents(){
        System.out.println("\n--- LISTAR ESTUDIANTES ---");

        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Student s : students) {
            System.out.println("\n" + s);
        }
    }

    private static void searchByName(){
        System.out.println("\n--- BÚSQUEDA DE ESTUDIANTE POR NOMBRE ---");
        System.out.print("Ingrese el nombre a buscar: ");
        String query = sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(query)) {
                System.out.println("\n" + s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    private static void showAverageGrade(){
        System.out.println("\n--- NOTA MEDIA GENERAL ---");

        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.getAvg();
        }

        double avg = total / students.size();
        System.out.printf("La nota media general es: %.2f\n", avg);
    }

    private static void showTopStudent(){
        System.out.println("\n--- MEJOR ESTUDIANTE ---");

        if (students.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        Student top = new Student();
        for (Student s : students) {
            if (s.getAvg() > top.getAvg()) {
                top = s;
            }
        }

        System.out.println("Estudiante con la mejor nota:");
        System.out.println(top);
    }




    private static boolean askEnrollmentStatus(){
        while (true) {
            System.out.print("¿Está matriculado? (si/no): ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("si")) return true;
            if (input.equals("no")) return false;

            System.out.println("Entrada no válida. Escribe 'si' o 'no'.");
        }
    }

    private static int readInt(String message){
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
            }
        }
    }

    private static float readFloat(String message){
        while (true) {
            System.out.print(message);
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número decimal válido.");
            }
        }
    }
}
