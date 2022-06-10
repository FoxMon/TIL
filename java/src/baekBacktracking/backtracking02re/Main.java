package baekBacktracking.backtracking02re;

import java.util.Scanner;

public class Main {
    public static int number;
    public static int[] numbers;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        numbers = new int[number];
        visited = new boolean[number];
        find(0);
    }

    public static void find(int level) {
        if(level == number) {
            for(int target : numbers) {
                System.out.print(target + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < number; i++) {
            if(!visited[i]) {
                visited[i] = true;
                numbers[level] = i + 1;
                find(level + 1);
                visited[i] = false;
            }
        }
    }
}
