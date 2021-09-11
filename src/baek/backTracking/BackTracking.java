package baek.backTracking;

import java.util.Scanner;

public class BackTracking { // 특정 경우를 만족하는 모든 경우의 수를 찾는 경우 ...
    public static int number;
    public static int count;
    public static int[] numbers;
    public static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int level = 0;
        number = scanner.nextInt();
        count = scanner.nextInt();
        isVisited = new boolean[number * 10];
        numbers = new int[number * 10];

        backTracking(level);
    }

    public static void backTracking(int level) {
        if(level == count) {
            for (int i = 0; i < count; i++) {
                System.out.print(numbers[i] + " ");
            }

            System.out.println();
            return;
        }

        for(int i = 1; i <= number; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                numbers[level] = i;
                backTracking(level + 1);
                isVisited[i] = false;
            }
        }
    }
}
