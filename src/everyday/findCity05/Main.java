package everyday.findCity05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int[] distance = new int[m + 1];
        ArrayList<Integer>[] city = new ArrayList[n + 1];

        for(int i = 0; i < city.length; i++) {
            city[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            city[scanner.nextInt()].add(scanner.nextInt());
        }

        distance[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < city[current].size(); i++) {
                if(distance[city[current].get(i)] == 0) {
                    distance[city[current].get(i)] = distance[current] + 1;
                    queue.offer(city[current].get(i));
                }
            }
        }

        boolean check = false;

        for(int i = 1; i < distance.length; i++) {
            if(distance[i] == k && i != k) {
                System.out.println(i);
                check = true;
            }
        }

        if(!check) {
            System.out.println(-1);
        }
    }
}
