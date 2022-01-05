package backData.data08;

import java.util.Scanner;
import java.util.Stack;

class Top {
    private int height;
    private int count;

    public Top(int height, int count) {
        this.height = height;
        this.count = count;
    }

    public int getHeight() { return this.height; }
    public int getCount() { return this.count; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int topCount = scanner.nextInt();
        Stack<Top> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i <= topCount; i++) {
            int height = scanner.nextInt();

            if(stack.isEmpty()) {
                stringBuilder.append("0 ");
                stack.push(new Top(height, i));
            } else {
                while(true) {
                    if(stack.isEmpty()) {
                        stringBuilder.append("0 ");
                        stack.push(new Top(height, i));
                        break;
                    }

                    Top top = stack.peek();
                    if(top.getHeight() > height) {
                        stringBuilder.append(top.getCount() + " ");
                        stack.push(new Top(height, i));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
