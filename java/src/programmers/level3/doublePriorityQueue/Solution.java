package programmers.level3.doublePriorityQueue;

import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(String oper : operations) {
            String[] commands = oper.split(" ");

            if(commands[0].equals("I")) {
                int target = Integer.parseInt(commands[1]);
                min.offer(target);
                max.offer(target);
            } else {
                if(!max.isEmpty()) {
                    if(commands[1].equals("1")) {
                        int target = max.peek();
                        min.remove(target);
                        max.remove(target);
                    } else {
                        int target = min.peek();
                        min.remove(target);
                        max.remove(target);
                    }
                }
            }
        }
        int[] answer = new int[2];
        if(min.isEmpty()) {
            answer[1] = 0;
        } else {
            answer[1] = min.poll();
        }
        if(max.isEmpty()) {
            answer[0] = 0;
        } else {
            answer[0] = max.poll();
        }
        return answer;
    }
}