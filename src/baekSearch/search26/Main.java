import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Computer implements Comparable<Computer> {
    private int vertex;
    private int cost;

    public Computer(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Computer temp) { return this.cost - temp.getCost(); }
}

public class Main {
    public static int computer;
    public static int dependency;
    public static int start;
    public static int[] costs;
    public static ArrayList<Computer>[] computers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            computer = scanner.nextInt();
            dependency = scanner.nextInt();
            start = scanner.nextInt();
            computers = new ArrayList[computer + 1];
            costs = new int[computer + 1];

            for(int i = 1; i <= computer; i++) {
                computers[i] = new ArrayList<>();
            }

            for(int i = 0; i < dependency; i++) {
                int first = scanner.nextInt();
                int end = scanner.nextInt();
                int weight = scanner.nextInt();
                computers[end].add(new Computer(first, weight));
            }

            find(start);
        }
    }

    public static void find(int first) {
        PriorityQueue<Computer> queue = new PriorityQueue<>();
        queue.offer(new Computer(first, 0));
        boolean[] visited = new boolean[computer + 1];
        Arrays.fill(visited, false);
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[first] = 0;
        int count = 0;
        int result = 0;

        while(!queue.isEmpty()) {
            Computer current = queue.poll();
            int currentVertex = current.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Computer computer : computers[currentVertex]) {
                    if(costs[computer.getVertex()] > computer.getCost() + costs[currentVertex]) {
                        costs[computer.getVertex()] = computer.getCost() + costs[currentVertex];
                        queue.offer(new Computer(computer.getVertex(), costs[computer.getVertex()]));
                    }
                }
            }
        }

        for(int i = 1; i <= computer; i++) {
            if(costs[i] != Integer.MAX_VALUE) {
                count++;
                result = Math.max(result, costs[i]);
            }
        }

        System.out.println(count + " " + result);
    }
}
