package programmers.level2.delivery;

import java.util.*;

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

public class Solution {
    public static ArrayList<Node>[] nodes;
    public static int[] costs;
    public static boolean[] visited;

    public static int solution(int N, int[][] road, int K) {
        nodes = new ArrayList[N + 1];
        costs = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < road.length; i++) {
            int first = road[i][0];
            int last = road[i][1];
            int weight = road[i][2];
            nodes[first].add(new Node(last, weight));
            nodes[last].add(new Node(first, weight));
        }

        find(1);
        int answer = 0;
        for(int result : costs) {
            if(result <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static void find(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

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
    }
}