package baek.printer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Print {
    private int index;
    private int primary;

    public Print(int index, int primary) {
        this.index = index;
        this.primary = primary;
    }

    public int getIndex() { return this.index; }
    public int getPrimary() { return this.primary; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for(int i = 0; i < count; i++) {
            int n  = scanner.nextInt();
            int m = scanner.nextInt();
            Queue<Print> queue = new LinkedList();
            int sequence = 1;

            for(int j = 0; j < n; j++) {
                queue.add(new Print(j, scanner.nextInt()));
            }

            while(!queue.isEmpty()) {
                Print print = queue.poll();
                boolean check = true;
                Iterator it = queue.iterator();

                while(it.hasNext()) {
                    Print value = (Print)it.next();
                    if(print.getPrimary() < value.getPrimary()) {
                        check = false;
                        break;
                    }
                }

                if(!check) {
                    queue.offer(print);
                } else {
                    if(print.getIndex() == m) {
                        System.out.println(sequence);
                    } else {
                        sequence++;
                    }
                }
            }
        }
    }
}
