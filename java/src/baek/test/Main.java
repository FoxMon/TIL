package baek.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] people = new int[count];

        for(int i = 0; i < count; i++) {
            people[i] = scanner.nextInt();
        }

        int b = scanner.nextInt();
        int c = scanner.nextInt();
        long result = count;

        for(int i = 0; i < count; i++) {
            people[i] -= b;

            if(people[i] > 0) {
                result += people[i] / c;

                if(people[i] % c != 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
