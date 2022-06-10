package baek.connectComponent02;

import java.util.Scanner;

public class Main {
    public static int vertex;
    public static int edge;
    public static int connectCount = 0;
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        visited = new boolean[vertex + 1];
        graph = new int[vertex + 1][vertex + 1];

        for(int i = 0; i < edge; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        for(int i = 1; i <= vertex; i++) {
            if(!visited[i]) {
                findConnect(i);
                connectCount++;
            }
        }

        System.out.println(connectCount);
    }

    public static void findConnect(int start) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;

        for(int i = 1; i <= vertex; i++) {
            if(graph[start][i] == 1) {
                findConnect(i);
            }
        }
    }
}
