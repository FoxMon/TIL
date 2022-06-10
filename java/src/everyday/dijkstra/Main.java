package everyday.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int weight;
    private int end;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight = node.getWeight();
    }

    public int getEnd() { return this.end; }
    public int getWeight() { return this.weight; }
    public void setEnd(int end) { this.end = end; }
    public void setWeight(int weight) { this.weight = weight; }
}

public class Main {
    public static final int INFINITE = Integer.MAX_VALUE;
    public static int vertex;
    public static int edge;
    public static int k;
    public static List<Node>[] list;
    public static int[] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        k = scanner.nextInt();
        list = new ArrayList[vertex + 1];
        distance = new int[vertex + 1];

        for(int i = 0; i < distance.length; i++) {
            distance[i] = INFINITE;
        }

        for(int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i =0; i < edge; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            list[start].add(new Node(end, weight));
        }

        StringBuilder stringBuilder = new StringBuilder();
        djkstra(k);

        for(int i =1; i <= vertex; i++) {
            if(distance[i] == INFINITE) {
                stringBuilder.append("Infinite \n");
            } else {
                stringBuilder.append(distance[i] + "\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }

    public static void djkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[vertex + 1];
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int curruent = currentNode.getEnd();

            if(check[curruent]) {
                continue;
            }

            check[curruent] = true;

            for(Node node : list[curruent]) {
                if(distance[node.getEnd()] > distance[curruent] + node.getWeight()) {
                    distance[node.getEnd()] = distance[curruent] + node.getWeight();
                    queue.add(new Node(node.getEnd(), distance[node.getEnd()]));
                }
            }
        }
    }
}
