package baekBacktracking.backtracking03;

import java.util.Scanner;

public class Main {
    public static int number;
    public static long min = Integer.MAX_VALUE;
    public static int[][] numbers;
    public static boolean[] visited;

    public static void main(String[] args) { // 종료조건 쌉중요.
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        numbers = new int[number][number];
        visited = new boolean[number];

        for(int i = 0; i < number; i++) {
            for(int j = 0; j < number; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < number; i++) {
            find(i, i, 0, 0); // start, now, level(count), sum
        }

        System.out.println(min);
    }

    public static void find(int start, int now, int level, int sum) {
        if(level == number && start == now) { // 전부 들렸으면 끝내야지. 시작점으로 다시 돌아오면 끝내야지.
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < number; i++) {
            if(!visited[i] && numbers[now][i] > 0) {
                visited[i] = true;
                sum += numbers[now][i];
                find(start, i, level + 1, sum);
                visited[i] = false;
                sum -= numbers[now][i];
            }
        }
    }
}
