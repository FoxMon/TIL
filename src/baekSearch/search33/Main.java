package baekSearch.search33;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int vertex;
    private int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int start;
    public static int last;
    public static ArrayList<Node>[] nodes;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        nodes = new ArrayList[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            nodes[i] = new ArrayList<>();
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            min = Math.min(min, cost);
            max = Math.max(max, cost);
            nodes[first].add(new Node(end, cost));
            nodes[end].add(new Node(first, cost));
        }

        start = scanner.nextInt();
        last = scanner.nextInt();
        int result = 0;

        while(min <= max) {
            int mid = (min + max) / 2;
            visited = new boolean[vertex + 1];
            if(find(mid)) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean find(int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            if(temp == last) {
                return true;
            }

            for(int i = 0; i < nodes[temp].size(); i++) {
                if(nodes[temp].get(i).getCost() >= mid && !visited[nodes[temp].get(i).getVertex()]) {
                    visited[nodes[temp].get(i).getVertex()] = true;
                    queue.offer(nodes[temp].get(i).getVertex());
                }
            }
        }

        return false;
    }
}
