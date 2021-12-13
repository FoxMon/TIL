package baek.balloon02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Number {
    private int order;
    private int target;

    public Number(int order, int target) {
        this.order = order;
        this.target = target;
    }

    public int getOrder() { return this.order; }
    public int getTarget() { return this.target; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int test = scanner.nextInt();
        Deque<Number> queue = new ArrayDeque<>();

        for(int i = 0; i < test; i++) {
            queue.add(new Number(i + 1, scanner.nextInt()));
        }

        while(!queue.isEmpty()) {
            stringBuilder.append(queue.getFirst().getOrder() + " ");
            int target = queue.pollFirst().getTarget();

            if(queue.isEmpty()) {
                break;
            }

            if(target > 0) {
                target--;

                for(int i = 0; i < target; i++) {
                    queue.addLast(queue.pollFirst());
                }
            } else {
                for(int i = 0; i < Math.abs(target); i++) {
                    queue.addFirst(queue.pollLast());
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
