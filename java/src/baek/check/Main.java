package baek.check;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];

        for(int i = 0; i < numberCount; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int temp = numbers[1] - numbers[0];

        for(int i = 2; i < numberCount; i++) {
            temp = getGcm(temp, numbers[i] - numbers[i - 1]);
        }

        for(int i = 2; i <= temp; i++) {
            if(temp % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static int getGcm(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }
}
