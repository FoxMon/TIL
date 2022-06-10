package programmers.level2.truck;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        int time = 0;
        int totalWeight = 0;

        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                if(queue.isEmpty()) {
                    queue.add(truck);
                    totalWeight += truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                } else {
                    if(totalWeight + truck <= weight) {
                        queue.add(truck);
                        totalWeight += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        answer = time + bridge_length;
        return answer;
    }
}
