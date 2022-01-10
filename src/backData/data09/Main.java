package backData.data09;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < count; i++) { // 3 5 2 7
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < count; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
