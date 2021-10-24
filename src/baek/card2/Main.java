package baek.card2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= count; i++) {
            queue.add(i);
        }

        while(true) {
            if(queue.size() == 1) {
                break;
            }

            queue.poll();
            int last = queue.poll();
            queue.add(last);
        }

        System.out.println(queue.poll());
    }
}
