package baek.nNumber;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int number = scanner.nextInt();
                if(queue.size() == size) {
                    if(queue.peek() < number) {
                        queue.poll();
                        queue.offer(number);
                    }
                } else {
                    queue.offer(number);
                }
            }
        }

        System.out.println(queue.poll());
    }
}
