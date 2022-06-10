package baek.absoluteHeap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2)));

        for(int i = 0; i < testCase; i++) {
            int number = scanner.nextInt();

            if(number == 0) {
                if(minHeap.isEmpty()) {
                    stringBuilder.append(0 + "\n");
                } else {
                    stringBuilder.append(minHeap.poll() + "\n");
                }
            } else {
                minHeap.add(number);
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
