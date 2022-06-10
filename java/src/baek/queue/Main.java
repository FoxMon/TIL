package baek.queue;

import java.util.ArrayList;
import java.util.Scanner;

class MyQueue {
    private ArrayList<Integer> queue;

    public MyQueue() {
        this.queue = new ArrayList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if(this.queue.isEmpty()) {
            return -1;
        }

        return this.queue.remove(0);
    }

    public int empty() {
        if(this.queue.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public int first() {
        if(this.queue.isEmpty()) {
            return -1;
        }

        return this.queue.get(0);
    }

    public int back() {
        if(this.queue.isEmpty()) {
            return -1;
        }

        return this.queue.get(this.queue.size() - 1);
    }

    public int size() { return this.queue.size(); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int count = scanner.nextInt();
        MyQueue myQueue = new MyQueue();

        for(int i = 0; i < count; i++) {
            String command = scanner.next();

            if(command.equals("push")) {
                int number = scanner.nextInt();
                myQueue.push(number);
            } else if(command.equals("pop")) {
                stringBuilder.append(myQueue.pop() + "\n");
            } else if(command.equals("size")) {
                stringBuilder.append(myQueue.size() + "\n");
            } else if(command.equals("empty")) {
                stringBuilder.append(myQueue.empty() + "\n");
            } else if(command.equals("front")) {
                stringBuilder.append(myQueue.first() + "\n");
            } else if(command.equals("back")) {
                stringBuilder.append(myQueue.back() + "\n");
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
