package baekSearch.search29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Home implements Comparable<Home> {
    private int vertex;
    private int cost;

    public Home(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }
    @Override
    public int compareTo(Home home) { return this.cost - home.getCost(); }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int distance;
    public static int myHome;
    public static int[] costs;
    public static boolean[] visited;
    public static ArrayList<Home>[] list;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        distance = scanner.nextInt();
        myHome = scanner.nextInt();
        list = new ArrayList[vertex];
        visited = new boolean[vertex];
        costs = new int[vertex];

        for(int i = 0; i < vertex; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            int cost = scanner.nextInt();
            list[first].add(new Home(last, cost));
            list[last].add(new Home(first, cost));
        }

        find(myHome);
        Arrays.sort(costs);

        int answer = 1;
        int total = 0;
        for(int i = 0; i < vertex; i++) {
            if(costs[i] * 2 > distance) {
                answer = -1;
                break;
            }
            total += costs[i] * 2;

            if(total > distance) {
                answer++;
                total = costs[i] * 2;
            }
        }

        System.out.println(answer);
    }

    public static void find(int start) {
        PriorityQueue<Home> queue = new PriorityQueue<>();
        queue.offer(new Home(start, 0));
        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        costs[start] = 0;

        while(!queue.isEmpty()) {
            Home home = queue.poll();
            int currentVertex = home.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Home temp : list[currentVertex]) {
                    if(!visited[temp.getVertex()] && costs[temp.getVertex()] > costs[currentVertex] + temp.getCost()) {
                        costs[temp.getVertex()] = costs[currentVertex] + temp.getCost();
                        queue.offer(new Home(temp.getVertex(), costs[temp.getVertex()]));
                    }
                }
            }
        }
    }
}
