package practice2.sum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long max = scanner.nextLong();
        int count = 0;
        long sum = 0;

        while(sum <= max) {
            count++;
            sum += count;
        }

        if(sum > max) {
            count--;
        }

        System.out.println(count);
    }
}
