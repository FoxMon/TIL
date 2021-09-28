package baek.compress;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) { // 3(2) 123(12) 12 121212
        Scanner scanner = new Scanner(System.in);
        String compress = scanner.next();
        Stack<Integer> number = new Stack<>();
        Stack<Integer> multiple = new Stack<>();
        int count = 0;

        for(int i = 0; i < compress.length(); i++) {
            char character = compress.charAt(i);

            if(character == '(') {
                count--;
                multiple.push(compress.charAt(i - 1) - '0');
                number.push(count);
                count = 0;
            } else if(character == ')') {
                int multipleNumber = multiple.pop();
                multipleNumber *= count;
                int plus = number.pop();
                count = plus + multipleNumber;
            } else {
                count++;
            }
        }

        System.out.println(count);
    }
}
