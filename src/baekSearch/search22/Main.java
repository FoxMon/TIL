package baekSearch.search22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Graph implements Comparable<Graph> {
    private int vertex;
    private int cost;

    public Graph(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Graph temp) { return this.cost - temp.getCost(); }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int[] costs;
    public static ArrayList<Graph>[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        costs = new int[vertex + 1];
        nodes = new ArrayList[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            int weight = scanner.nextInt();
            nodes[first].add(new Graph(last, weight));
            nodes[last].add(new Graph(first, weight));
        }

        int start1 = scanner.nextInt();
        int start2 = scanner.nextInt();
        long result1 = 0;
        long result2 = 0;

        // 1 -> start1 -> start2 -> destination
        // 1 -> start2 -> start1 -> destination
        result1 += find(1, start1);
        result1 += find(start1, start2);
        result1 += find(start2, vertex);
        result2 += find(1, start2);
        result2 += find(start2, start1);
        result2 += find(start1, vertex);

        if(result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    public static int find(int start, int end) {
        PriorityQueue<Graph> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[vertex + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;
        queue.offer(new Graph(start, 0));

        while(!queue.isEmpty()) {
            Graph current = queue.poll();
            int currentVertex = current.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Graph graph : nodes[currentVertex]) {
                    if(costs[graph.getVertex()] > graph.getCost() + costs[currentVertex]) {
                        costs[graph.getVertex()] = graph.getCost() + costs[currentVertex];
                        queue.offer(new Graph(graph.getVertex(), costs[graph.getVertex()]));
                    }
                }
            }
        }

        return costs[end];
    }
}
