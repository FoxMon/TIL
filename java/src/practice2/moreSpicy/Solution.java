package practice2.moreSpicy;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int scovile_num : scoville) {
            heap.offer(scovile_num);
        }

        while(heap.peek() <= K) {
            if(heap.size() == 1) {
                return -1;
            }

            int a = heap.poll();
            int b = heap.poll();
            int result = a + (b * 2);

            heap.offer(result);
            answer++;
        }

        return answer;
    }
}
