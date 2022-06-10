package backData.data09re;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        for(int i = 0; i < count; i++) { // 3 5 2 7
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int number : numbers) {
            stringBuilder.append(number + " ");
        }
        System.out.println(stringBuilder.toString());
    }
}
