package baek.hideGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int k;
    public static int[] distance = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        if(n == k) {
            System.out.println(0);
            System.exit(0);
        } else {
            distance[n] = 1;
            findBrother();
        }
    }

    public static void findBrother() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int step = queue.poll();

            for(int i = 0; i < 3; i++) {
                int nextStep;
                if(i == 0) { // walk
                    nextStep = step + 1;
                } else if(i == 1) { // teleport
                    nextStep = step * 2;
                } else { // back moving
                    nextStep = step - 1;
                }

                if(nextStep == k) {
                    System.out.println(distance[step]);
                    return;
                }

                if(nextStep >= 0 && nextStep < distance.length && distance[nextStep] == 0) {
                    queue.add(nextStep);
                    distance[nextStep] = distance[step] + 1;
                }
            }
        }
    }
}
