package org.example;

public class Student {

        private String name;
        private int age;
        private float avg;
        private boolean isEnrolled;

        public Student()
        {
            name = "";
            age = 0;
            avg = 0;
            isEnrolled = false;
        }

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

    }
