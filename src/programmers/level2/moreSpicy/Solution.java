package programmers.level2.moreSpicy;

import java.util.*;

public class Solution { // 스코빌 -> 안매운거 1등 + (2번째 안매운거 * 스코빌)
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;

        for(int spicy : scoville) {
            queue.offer(spicy);
        }

        while(queue.peek() < K) {
            if(queue.size() <= 1) {
                return -1;
            }

            int first = queue.poll();
            int second = queue.poll();
            int result = first + (second * 2);
            queue.offer(result);
            answer++;
        }

        return answer;
    }
}