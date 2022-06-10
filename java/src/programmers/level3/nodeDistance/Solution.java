package programmers.level3.nodeDistance;

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
    public int compareTo(Node node) { return this.cost - node.getCost(); }
}

public class Solution {
    public static ArrayList<Node>[] nodes;
    public static int[] costs;
    public static boolean[] visited;

    public static int solution(int n, int[][] edge) {
        nodes = new ArrayList[n + 1];
        costs = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++) {
            int first = edge[i][0];
            int end = edge[i][1];
            int weight = 1;
            nodes[first].add(new Node(end, weight));
            nodes[end].add(new Node(first, weight));
        }

        int max = find(1);
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            if(max == costs[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static int find(int start) {
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
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

        int result = 0;

        for(int i = 1; i < costs.length; i++) {
            result = Math.max(costs[i], result);
        }

        return result;
    }
}
