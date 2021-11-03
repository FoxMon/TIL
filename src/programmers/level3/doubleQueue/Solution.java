package programmers.level3.doubleQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");

            if(command[0].equals("I")) {
                int number = Integer.parseInt(command[1]);
                min.offer(number);
                max.offer(number);
            } else {
                if(!max.isEmpty()) {
                    if(command[1].equals("1")) {
                        int target = max.peek();
                        max.remove(target);
                        min.remove(target);
                    } else {
                        int target = min.peek();
                        max.remove(target);
                        min.remove(target);
                    }
                }
            }
        }

        if(!min.isEmpty() && !max.isEmpty()) {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }

        return answer;
    }
}
