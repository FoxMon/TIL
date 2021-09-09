package baek.fibo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int result = fibo(target);
        System.out.println(result);
    }

    public static int fibo(int number) {
        if(number == 0) {
            return 0;
        } else if(number == 1) {
            return 1;
        }

        return fibo(number - 1) + fibo(number - 2);
    }
}
