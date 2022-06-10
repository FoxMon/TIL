package baekGreedy.greedy02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] numbers = new String[count]; // AAA -> 100
        int[] alpha = new int[26];

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.next();
        }

        for(int i = 0; i < count; i++) {
            int target = (int)Math.pow(10, numbers[i].length() - 1);

            for(int j = 0; j < numbers[i].length(); j++) {
                alpha[(int)numbers[i].charAt(j) - 'A'] += target;
                target /= 10;
            }
        }

        Arrays.sort(alpha);
        int index = 9;
        int sum = 0;

        for(int i = alpha.length - 1; i >= 0; i--) {
            if(alpha[i] == 0) {
                break;
            }

            sum += alpha[i] * index;
            index--;
        }

        System.out.println(sum);
    }
}
