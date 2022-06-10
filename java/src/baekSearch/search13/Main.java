package baekSearch.search13;

import java.util.Scanner;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static int n;
    public static int m;
    public static int[] numbers;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        numbers = new int[m];
        visited = new boolean[n];

        backTracking(0);
        System.out.println(stringBuilder.toString());
    }

    public static void backTracking(int count) {
        if(count >= m) {
            for(int number : numbers) {
                stringBuilder.append(number + " ");
            }

            stringBuilder.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                numbers[count] = i + 1;
                backTracking(count + 1);
                visited[i] = false;
            }
        }
    }
}
