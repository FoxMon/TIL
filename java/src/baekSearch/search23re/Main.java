package baekSearch.search23re;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Map implements Comparable<Map> {
    private int vertex;
    private int cost;

    public Map(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Map map) { return this.cost - map.getCost(); }
}

public class Main {
    public static int vertex;
    public static int limit;
    public static int edge;
    public static int[] items;
    public static int[] costs;
    public static boolean[] visited;
    public static ArrayList<Map>[] maps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        limit = scanner.nextInt();
        edge = scanner.nextInt();
        items = new int[vertex + 1];
        costs = new int[vertex + 1];
        visited = new boolean[vertex + 1];
        maps = new ArrayList[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            items[i] = scanner.nextInt();
            maps[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            maps[first].add(new Map(end, weight));
            maps[end].add(new Map(first, weight));
        }

        int answer = 0;

        for(int i = 1; i <= vertex; i++) {
            answer = Math.max(answer, find(i));
        }

        System.out.println(answer);
    }

    public static int find(int start) {
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        PriorityQueue<Map> queue = new PriorityQueue<>();
        queue.offer(new Map(start, 0));
        costs[start] = 0;

        while(!queue.isEmpty()) {
            Map current = queue.poll();
            int currentVertex = current.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Map map : maps[currentVertex]) {
                    if(!visited[map.getVertex()] && costs[map.getVertex()] > map.getCost() + costs[currentVertex]) {
                        costs[map.getVertex()] = map.getCost() + costs[currentVertex];
                        queue.offer(new Map(map.getVertex(), costs[map.getVertex()]));
                    }
                }
            }
        }

        int result = 0;

        for(int i = 1; i <= vertex; i++) {
            if(costs[i] <= limit) {
                result += items[i];
            }
        }

        return result;
    }
}