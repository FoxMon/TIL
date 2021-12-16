package baekBFS.bfs01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static boolean[] check;
    public static int[][] computers;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computer = scanner.nextInt();
        int number = scanner.nextInt();
        computers = new int[computer + 1][computer + 1];
        check = new boolean[computer + 1];

        for(int i = 0; i < number; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            computers[first][last] = computers[last][first] = 1;
        }

        find(1);
        System.out.println(count);
    }

    public static void find(int start) {
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int i = 1; i < computers.length; i++) {
                if(computers[x][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                    count++;
                }
            }
        }
    }
}
