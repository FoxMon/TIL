package baek.sanguenTravel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[][] country;
    public static int result;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            result = 0;
            country = new int[n + 1][n + 1];
            visited = new boolean[n + 1];

            for(int j = 0; j < m; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                country[start][end] = 1;
                country[end][start] = 1;
            }

            goTravel();
            System.out.println(result - 1);
        }
    }

    public static void goTravel() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int value = queue.poll();
            result++;

            for(int i = 1; i <= n; i++) {
                if(country[value][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
