package baekSearch.search21;

import java.util.*;

class Student implements Comparable<Student> {
    private int vertex;
    private int cost;

    public Student(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    public int getVertex() { return this.vertex; }
    public int getCost() { return this.cost; }

    @Override
    public int compareTo(Student temp) { return this.cost - temp.getCost(); }
}

public class Main {
    public static int vertex;
    public static int edge;
    public static int x;
    public static ArrayList<Student>[] students;
    public static ArrayList<Student>[] studentsBack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vertex = scanner.nextInt();
        edge = scanner.nextInt();
        x = scanner.nextInt();
        students = new ArrayList[vertex + 1];
        studentsBack = new ArrayList[vertex + 1];

        for(int i = 1; i <= vertex; i++) {
            students[i] = new ArrayList<>();
            studentsBack[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            students[start].add(new Student(end, weight));
            studentsBack[end].add(new Student(start, weight));
        }

        int[] results1 = find(students);
        int[] results2 = find(studentsBack);
        int result = 0;

        for(int i = 1; i <= vertex; i++) {
            result = Math.max(result, results1[i] + results2[i]);
        }

        System.out.println(result);
    }

    public static int[] find(ArrayList<Student>[] temp) {
        PriorityQueue<Student> queue = new PriorityQueue<>();
        queue.offer(new Student(x, 0));
        boolean[] visited = new boolean[vertex + 1];
        int[] costs = new int[vertex + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[x] = 0;

        while(!queue.isEmpty()) {
            Student current = queue.poll();
            int currentVertex = current.getVertex();

            if(!visited[currentVertex]) {
                visited[currentVertex] = true;

                for(Student student : temp[currentVertex]) {
                    if(costs[student.getVertex()] > student.getCost() + costs[currentVertex]) {
                        costs[student.getVertex()] = student.getCost() + costs[currentVertex];
                        queue.offer(new Student(student.getVertex(), costs[student.getVertex()]));
                    }
                }
            }
        }

        return costs;
    }
}
