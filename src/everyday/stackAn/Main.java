package everyday.stackAn;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int numberCount = scanner.nextInt();
        int[] numbers = new int[numberCount];
        Stack<Integer> basket = new Stack<>();

        for(int i = 0; i < numberCount; i++) {
            numbers[i] = scanner.nextInt();
        }

        int pushNumber = 1;
        int popNumber = 0;

        for(int i = 0; i < numberCount; i++) {
            int target = numbers[i];

            while(pushNumber <= target) {
                basket.push(pushNumber++);
                stringBuilder.append("+" + "\n");
            }

            while(popNumber !=  target) {
                if(!basket.isEmpty()) {
                    popNumber = basket.pop();
                    stringBuilder.append("-" + "\n");
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
