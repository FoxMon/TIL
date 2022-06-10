package everyday.kruskal;

import java.util.Scanner;

public class Kruskal { // greedy, find MST ( Minimum Spanning Tree )
    public static int vertex; // Spanning tree -> Cycle X
    public static int edge;
    public static int cost;
    public static int[] parent;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        cost = 0;
        parent = new int[vertex];
        graph = new int[edge][3]; // node1, node2, cost

        for(int i = 0; i < edge; i++) {
            graph[i][0] = scanner.nextInt();
            graph[i][1] = scanner.nextInt();
            graph[i][2] = scanner.nextInt();
        }

        for(int i = 0; i < vertex; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < edge; i++) {
            if(find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                union(graph[i][0] - 1, graph[i][1] - 1);
                cost += graph[i][2];
            }
        }
    }

    public static int find(int vertex) {
        if(parent[vertex] == vertex) {
            return vertex;
        }

        return find(parent[vertex]);
    }

    public static void union(int vertex1, int vertex2) {
        vertex1 = find(vertex1);
        vertex2 = find(vertex2);

        if(vertex1 > vertex2) {
            parent[vertex1] = vertex2;
        } else {
            parent[vertex2] = vertex1;
        }
    }
}
