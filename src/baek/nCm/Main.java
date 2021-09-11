package baek.nCm;

import java.util.Scanner;

public class Main {
    public static int[] numbers;
    public static boolean[] isVisited;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        numbers = new int[m];
        isVisited = new boolean[n];
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

        for(int i = 0; i < isVisited.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                numbers[level] = i + 1;
                backTracking(n, m, level + 1);
                isVisited[i] = false;
            }
        }
    }
}
