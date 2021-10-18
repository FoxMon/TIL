package baek.printer02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Printer {
    private int index;
    private int primary;

    public Printer(int index, int primary) {
        this.index = index;
        this.primary = primary;
    }

    public int getIndex() { return this.index; }
    public int getPrimary() { return this.primary; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int result = 1;
            Queue<Printer> queue = new LinkedList<>();

            for(int j = 0; j < n; j++) {
                queue.offer(new Printer(j, scanner.nextInt()));
            }

            while(!queue.isEmpty()) {
                Printer current = queue.poll();
                Iterator iterator = queue.iterator();
                boolean check = true;

                while(iterator.hasNext()) {
                    Printer value = (Printer)iterator.next();

                    if(current.getPrimary() < value.getPrimary()) {
                        check = false;
                        break;
                    }
                }

                if(!check) {
                    queue.offer(current);
                } else {
                    if(current.getIndex() == m) {
                        System.out.println(result);
                    } else {
                        result++;
                    }
                }
            }
        }
    }
}
