package backData.data05;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;
        int number = scanner.nextInt();
        int target = scanner.nextInt();
        int[] numbers = new int[target];

        for(int i = 1; i <= number; i++) {
            deque.add(i);
        }

        for(int i = 0; i < target; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < target; i++) {
            int index = deque.indexOf(numbers[i]);
            int half;

            if(deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            } else {
                half = deque.size() / 2;
            }

            if(index <= half) {
                for(int j = 0; j < index; j++) {
                    int temp = deque.pollFirst();
                    deque.add(temp);
                    count++;
                }
            } else {
                for(int j = 0; j < deque.size() - index; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
