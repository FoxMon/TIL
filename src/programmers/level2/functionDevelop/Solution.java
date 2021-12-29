package programmers.level2.functionDevelop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double)speeds[i];
            int date = (int)Math.ceil(remain);

            if(!queue.isEmpty() && queue.peek() < date) {
                result.add(queue.size());
                queue.clear();
            }

            queue.offer(date);
        }

        result.add(queue.size());
        int[] answer = new int[result.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
