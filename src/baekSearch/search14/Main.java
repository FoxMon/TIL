package baekSearch.search14;

import java.util.Scanner;

public class Main {
    public static int numberCount;
    public static int[] numbers;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            numberCount = scanner.nextInt();

            if(numberCount == 0) {
                System.exit(0);
            }

            numbers = new int[numberCount];
            visited = new boolean[numberCount];

            for(int i = 0; i < numberCount; i++) {
                numbers[i] = scanner.nextInt();
            }

            backTracking(0, 0);
            System.out.println();
        }
    }

    public static void backTracking(int start, int level) {
        if(level >= 6) {
            for(int i = 0; i < numberCount; i++) {
                if(visited[i]) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start; i < numberCount; i++) {
            visited[i] = true;
            backTracking(i + 1, level + 1);
            visited[i] = false;
        }
    }
}
