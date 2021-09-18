package baek.factorCount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while(count-- > 0) {
            int num = scanner.nextInt();
            max = num > max ? num : max;
            min = num < min ? num : min;
        }

        System.out.println(max * min);
    }
}
