package practice3.makeMin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[2];

        for(int i = 0; i < 2; i++) {
            numbers[i] = scanner.nextInt();
        }

        int result = makeMin(numbers[0], numbers[1]);

        System.out.println(result);
    }

    public static int makeMin(int num1, int num2) {
        if(num1 < num2) {
            return num1;
        } else {
            return num2;
        }
    }
}
