package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    private static ArrayList<Student> studentList = new ArrayList<>();

    static class Student {
        private String name;
        private int age;
        private float avg;
        private boolean isEnrolled;

        public Student(String name, int age, float avg, boolean isEnrolled) {
            this.name = name;
            this.age = age;
            this.avg = avg;
            this.isEnrolled = isEnrolled;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getAvg() {
            return avg;
        }

        public boolean getEnrolled() {
            return isEnrolled;
        }

        @Override
        public String toString() {
            String enrolled = isEnrolled ? "Si" : "No";
            StringBuilder sb = new StringBuilder();

            sb.append(name)
                    .append("\nEdad: ").append(age)
                    .append("\nNota: ").append(avg)
                    .append("\nEstá matriculado: ").append(enrolled);

            return sb.toString();
        }

        public static void Main(String[] args)
        {

        }
    }
}