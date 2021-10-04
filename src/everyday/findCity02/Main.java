package everyday.findCity02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int x;
    public static int[] distance;
    public static ArrayList<Integer>[] city;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();
        city = new ArrayList[n + 1];

        for(int i = 0; i < city.length; i++) {
            city[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            city[scanner.nextInt()].add(scanner.nextInt());
        }

        distance = new int[m + 1];
        Queue<Integer> queue = new LinkedList<>();
        distance[x] = 0;
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
            if(distance[i] == k && i != x) {
                check = true;
                System.out.println(i);
            }
        }

        if(!check) {
            System.out.println(-1);
        }
    }
}
