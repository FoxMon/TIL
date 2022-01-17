package leetCode.canFinish;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] arr = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][0];
            int last = prerequisites[i][1];
            if(arr[last][first] == 0) {
                degree[first]++;
            }
            arr[last][first] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) { queue.offer(i); }
        }

        while(!queue.isEmpty()) {
            int target = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if(arr[target][i] != 0) {
                    degree[i]--;
                    if(degree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
