package baek.dpMakeOne;

import java.util.Scanner;

public class Main {
    public static Integer[] count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        count = new Integer[number + 1];
        count[0] = count[1] = 0;

        System.out.println(makeOne(number));
    }

    public static int makeOne(int number) {
        if(count[number] == null) {
            if (number % 6 == 0) {
                count[number] = Math.min(makeOne(number - 1), Math.min(makeOne(number / 3), makeOne(number / 2))) + 1;
            } else if (number % 3 == 0) {
                count[number] = Math.min(makeOne(number / 3), makeOne(number - 1)) + 1;
            } else if (number % 2 == 0) {
                count[number] = Math.min(makeOne(number / 2), makeOne(number - 1)) + 1;
            } else {
                count[number] = makeOne(number - 1) + 1;
            }
        }

        return count[number];
    }
}
