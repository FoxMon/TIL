package baekMath.math03;

import java.util.Scanner;

public class Main {
    public static int number;
    public static boolean[] target;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = new boolean[1000000 + 1];
        target[0] = target[1] = true;
        for(int i = 2; i * i <= 1000000; i++) {
            if(!target[i]) {
                for(int j = i * i; j <= 1000000; j += i) {
                    target[j] = true;
                }
            }
        }

        while(true) {
            number = scanner.nextInt();
            if(number == 0) {
                System.exit(0);
            }
            boolean flag = false;
            for(int i = 2; i <= number/2; i++) {
                if(!target[i] && !target[number - i]) {
                    System.out.println(number + " = " + i + " + " + (number - i));
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
