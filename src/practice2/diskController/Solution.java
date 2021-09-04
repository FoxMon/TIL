package practice2.diskController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });

        return controll(jobs);
    }

    public static int controll(int[][] jobs) {
        PriorityQueue<int[]> diskController = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        diskController.offer(jobs[0]);
        int end = jobs[0][0];
        int sum = 0;
        int index = 1;

        while(!diskController.isEmpty()) {
            int[] current = diskController.poll();
            end += current[1];
            sum += end - current[0];

            while(index < jobs.length && jobs[index][0] <= end) {
                diskController.offer(jobs[index++]);
            }

            if(index < jobs.length && diskController.isEmpty()) {
                end = jobs[index][0];
                diskController.offer(jobs[index++]);
            }
        }

        return sum / jobs.length;
    }
}
