package baek.printer03;

import java.util.*;

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
        int count = scanner.nextInt();

        for(int i = 0; i < count; i++) {
            int document = scanner.nextInt();
            int index = scanner.nextInt();
            int result = 1;
            Queue<Printer> queue = new LinkedList<>();

            for(int j = 0; j < document; j++) {
                queue.offer(new Printer(j, scanner.nextInt()));
            }

            while(!queue.isEmpty()) {
                Printer current = queue.poll();
                Iterator iterator = queue.iterator();
                boolean check = true;

                while(iterator.hasNext()) {
                    Printer value = (Printer) iterator.next();

                    if(current.getPrimary() < value.getPrimary()) {
                        check = false;
                        break;
                    }
                }

                if(!check) {
                    queue.offer(current);
                } else {
                    if(current.getIndex() == index) {
                        System.out.println(result);
                    } else {
                        result++;
                    }
                }
            }
        }
    }
}
