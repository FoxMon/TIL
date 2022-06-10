package baekSearch.search01re;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] computers;
    public static boolean[] check;

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

        System.out.println(find(1));
    }

    public static int find(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        check[start] = true;
        queue.offer(1);

        while(!queue.isEmpty()) {
            int first = queue.poll();

            for(int i = 1; i < computers.length; i++) {
                if(computers[first][i] == 1 && !check[i]) {
                    queue.offer(i);
                    check[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
