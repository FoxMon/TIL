package backData.data07;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            int count = scanner.nextInt();
            PriorityQueue<Long> queue = new PriorityQueue<>();

            for(int i = 0; i < count; i++) {
                queue.offer(scanner.nextLong());
            }
            long sum = 0;
            while(queue.size() > 1) {
                long num1 = queue.poll();
                long num2 = queue.poll();
                sum += num1 + num2;
                queue.offer(num1 + num2);
            }
            System.out.println(sum);
        }
    }
}
