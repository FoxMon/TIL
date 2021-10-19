package baek.stack;

import java.util.ArrayList;
import java.util.Scanner;

class MyStack {
    private ArrayList<Integer> stack;
    private int top;

    public MyStack() {
        this.stack = new ArrayList<>();
        this.top = -1;
    }

    public void push(int x) {
        this.top++;
        this.stack.add(x);
    }

    public int top() {
        if(this.stack.isEmpty()) {
            return -1;
        }

        int result = this.stack.get(this.top);
        return result;
    }

    public int pop() {
        if(this.stack.isEmpty()) {
            return -1;
        }

        int result = this.stack.get(this.top);
        this.stack.remove(this.top);
        this.top--;
        return result;
    }

    public int empty() {
        if(this.stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int size() { return this.stack.size(); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int n = scanner.nextInt();
        MyStack myStack = new MyStack();

        for(int i = 0; i < n; i++) {
            String command = scanner.next();

            if(command.equals("push")) {
                int number = scanner.nextInt();
                myStack.push(number);
            } else if(command.equals("top")) {
                stringBuilder.append(myStack.top() + "\n");
            } else if(command.equals("size")) {
                stringBuilder.append(myStack.size() + "\n");
            } else if(command.equals("pop")) {
                stringBuilder.append(myStack.pop() + "\n");
            } else if(command.equals("empty")) {
                stringBuilder.append(myStack.empty() + "\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
