package baek.nCm2;

import java.util.Scanner;

public class Main {
    public static int[] numbers;
    public static int n, m;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[m];
        backTracking(1, 0);
        System.out.println(stringBuilder.toString());
    }

    public static void backTracking(int start, int level) {
        if(level >= m) {
            for(int number : numbers) {
                stringBuilder.append(number + " ");
            }

            stringBuilder.append("\n");
            return;
        }

        for(int i = start; i <= n; i++) {
            numbers[level] = i;
            backTracking(i + 1, level + 1);
        }
    }
}
