package baek.minHeap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < testCase; i++) {
            int number = scanner.nextInt();

            if(number == 0) {
                if(queue.isEmpty()) {
                    stringBuilder.append(0 + "\n");
                } else {
                    stringBuilder.append(queue.poll() + "\n");
                }
            } else {
                queue.add(number);
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
