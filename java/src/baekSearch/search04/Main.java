package baekSearch.search04;

import java.util.Scanner;

public class Main {
    public static int vertex;
    public static int edge;
    public static int count = 0;
    public static int[][] node;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        node = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for(int i = 0; i < edge; i++) {
            int firstVertex = scanner.nextInt();
            int lastVertex = scanner.nextInt();
            node[firstVertex][lastVertex] = node[lastVertex][firstVertex] = 1;
        }

        for(int i = 1; i <= vertex; i++) {
            if(!visited[i]) {
                findEdge(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void findEdge(int start) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;

        for(int i = 1; i <= vertex; i++) {
            if(node[start][i] == 1) {
                findEdge(i);
            }
        }
    }
}
