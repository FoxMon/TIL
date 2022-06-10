package baek.plusCycle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = n;
        int count = 0;

        while(true) {
            int start = temp / 10;
            int end = temp % 10;
            temp = end * 10 + (start + end) % 10;
            count++;

            if(temp == n) {
                break;
            }
        }

        System.out.println(count);
    }
}
