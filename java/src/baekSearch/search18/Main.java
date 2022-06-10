package baekSearch.search18;

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
    public int compareTo(Node temp) {
        return this.cost - temp.getCost();
    }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int start;
    public static int[] costs;
    public static ArrayList<Node>[] nodes;

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        start = scanner.nextInt();
        nodes = new ArrayList[vertex + 1];
        costs = new int[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            nodes[i] = new ArrayList<>();
            costs[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            nodes[first].add(new Node(end, cost));
        }

        dijkstra(start);

        for(int i = 1; i <= vertex; i++) {
            if(costs[i] == Integer.MAX_VALUE) {
                stringBuilder.append("INF\n");
            } else {
                stringBuilder.append(costs[i] + "\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    public static void dijkstra(int first) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[vertex + 1];
        queue.offer(new Node(first, 0));
        costs[first] = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.getVertex();

            if(!check[currentVertex]) {
                check[currentVertex] = true;

                for(Node node : nodes[currentVertex]) {
                    if(costs[node.getVertex()] > costs[currentVertex] + node.getCost()) {
                        costs[node.getVertex()] = costs[currentVertex] + node.getCost();
                        queue.offer(new Node(node.getVertex(), costs[node.getVertex()]));
                    }
                }
            }
        }
    }
}
