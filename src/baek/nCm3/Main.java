package baek.nCm3;

import java.util.Scanner;

public class Main {
    public static int[] numbers;
    public static int n;
    public static int m;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[m];
        backTracking(n, m, 0);
        System.out.println(stringBuilder.toString());
    }

    public static void backTracking(int n, int m, int level) {
        if(level >= m) {
            for(int number : numbers) {
                stringBuilder.append(number + " ");
            }

            stringBuilder.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            numbers[level] = i + 1;
            backTracking(n, m, level + 1);
        }
    }
}
