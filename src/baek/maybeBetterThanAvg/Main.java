package baek.maybeBetterThanAvg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        double[] ratios = new double[cases];

        for(int i = 0; i < cases; i++) {
            int student_count = scanner.nextInt();
            int[] students = new int[student_count];

            for(int j = 0; j < students.length; j++) {
                students[j] = scanner.nextInt();
            }

            ratios[i] = getRatio(students);
        }

        for(double ratio : ratios) {
            System.out.printf("%.3f", ratio);
            System.out.println("%");
        }
    }

    public static double getRatio(int[] students) {
        int total = 0;
        int count = 0;

        for(int student : students) {
            total += student;
        }

        double avg = (double)total / students.length;

        for(int student : students) {
            if(avg < student) {
                count++;
            }
        }

        return ((100.0 * count) / (students.length));
    }
}
