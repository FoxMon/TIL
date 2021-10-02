package everyday.cardSort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        PriorityQueue<Long> number = new PriorityQueue<>();

        for(int i = 0; i < count; i++) {
            number.add(scanner.nextLong());
        }

        long result = 0;

        while(number.size() != 1) {
            long first = number.poll();
            long second = number.poll();
            long sum = first + second;
            result += sum;
            number.add(sum);
        }

        System.out.println(result);
    }
}
