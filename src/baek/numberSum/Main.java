package baek.numberSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String str = scanner.next();
        int[] numbers = new int[count];
        int sum = 0;

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(str.charAt(i) + "");
            sum += numbers[i];
        }

        System.out.println(sum);
    }
}
