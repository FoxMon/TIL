package baek.dpMakeEasyStairCount;

import java.util.Scanner;

public class Main {
    public static Long[][] dpStair;
    public static int numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.nextInt();
        dpStair = new Long[numbers + 1][10];

        for(int i = 0; i < 10; i++) {
            dpStair[1][i] = 1L;
        }

        long count = 0;

        for(int i = 1; i < 10; i++) {
            count += find(numbers, i);
        }

        System.out.println(count % 1000000000);
    }

    public static long find(int level, int number) {
        if(level == 1) {
            return dpStair[level][number];
        }

        if(dpStair[level][number] == null) {
            if(number == 0) {
                dpStair[level][number] = find(level - 1, 1);
            } else if(number == 9) {
                dpStair[level][number] = find(level - 1, 8);
            } else {
                dpStair[level][number] = find(level - 1, number - 1) + find(level - 1, number + 1);
            }
        }
        return dpStair[level][number] % 1000000000;
    }
}
