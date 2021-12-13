package baek.balloon01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Pair {
    private int order;
    private int number;

    public Pair(int order, int number) {
        this.order = order;
        this.number = number;
    }

    public int getOrder() { return this.order; }
    public int getNumber() { return this.number; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int number = scanner.nextInt();
        Deque<Pair> deque = new ArrayDeque<>();

        for(int i = 0; i < number; i++) {
            deque.add(new Pair(i + 1, scanner.nextInt()));
        }

        while(!deque.isEmpty()) {
            stringBuilder.append(deque.getFirst().getOrder() + " ");
            int target = deque.poll().getNumber();

            if(deque.isEmpty()) {
                break;
            }

            if(target > 0) {
                target -= 1;

                for(int i = 0; i < target; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for(int i = 0; i < Math.abs(target); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
