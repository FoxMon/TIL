package baekSearch.search19re;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int vertex;
    private int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Node temp) { return this.cost - temp.getCost(); }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int[] costs;
    public static ArrayList<Node>[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        costs = new int[vertex + 1];
        nodes = new ArrayList[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            costs[i] = Integer.MAX_VALUE;
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            int startVertex = scanner.nextInt();
            int endVertex = scanner.nextInt();
            int weight = scanner.nextInt();
            nodes[startVertex].add(new Node(endVertex, weight));
        }

        int firstVertex = scanner.nextInt();
        int lastVertex = scanner.nextInt();
        System.out.println(find(firstVertex, lastVertex));
    }

    public static int find(int first, int last) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[vertex + 1];
        costs[first] = 0;
        queue.offer(new Node(first, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Node node : nodes[currentVertex]) {
                    if(costs[node.getVertex()] > node.getCost() + costs[currentVertex]) {
                        costs[node.getVertex()] = node.getCost() + costs[currentVertex];
                        queue.offer(new Node(node.getVertex(), costs[node.getVertex()]));
                    }
                }
            }
        }

        return costs[last];
    }
}
