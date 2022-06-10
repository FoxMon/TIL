package programmers.level2.printer;

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

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int result = 1;
        Queue<Printer> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Printer(i, priorities[i]));
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
                if(current.getIndex() == location) {
                    answer = result;
                    break;
                } else {
                    result++;
                }
            }
        }

        return answer;
    }
}