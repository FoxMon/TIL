package baek.hideGame02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int k;
    public static int[] sister = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        if(n == k) {
            System.out.println(0);
            System.exit(0);
        } else {
            sister[n] = 1;
            findBrother();
        }
    }

    public static void findBrother() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < 3; i++) {
                int nextStep;

                if(i == 0) { // go
                    nextStep = current + 1;
                } else if(i == 1) { // teleport
                    nextStep = current * 2;
                } else { //back;
                    nextStep = current - 1;
                }

                if(nextStep == k) {
                    System.out.println(sister[current]);
                    return;
                }

                if(nextStep >= 0 && nextStep < sister.length && sister[nextStep] == 0) {
                    sister[nextStep] = sister[current] + 1;
                    queue.offer(nextStep);
                }
            }
        }
    }
}
