package practice3.test02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = new int[2];
        int sum = 0;

        for(int i = 0; i < range.length; i++) {
            range[i] = scanner.nextInt();
        }

        for(int i = range[0]; i <= range[1]; i++) {
            if(i % 2 == 1) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
