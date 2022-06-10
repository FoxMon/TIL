package baek.zero;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Long> report = new Stack<>();
        long number = scanner.nextInt();
        long input;

        for(int i = 0; i < number; i++) {
            input = scanner.nextInt();
            if(input == 0) {
                report.pop();
            } else {
                report.push(input);
            }
        }

        long result = 0;
        while(!report.isEmpty()) {
            result += report.pop();
        }

        System.out.println(result);
    }
}
