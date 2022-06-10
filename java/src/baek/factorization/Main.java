package baek.factorization;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        for(int i = 2; i <= target; i++) {
            while(target % i == 0) {
                System.out.println(i);
                target /= i;
            }
        }
    }
}
