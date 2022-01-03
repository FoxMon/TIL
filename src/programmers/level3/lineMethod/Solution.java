package programmers.level3.lineMethod;

import java.util.ArrayList;

public class Solution {
    public static boolean[] visited;
    public static int[] numbers;
    public static ArrayList<int[]> result;
    public static int[] nums;

    public void solution(int n, long k) {
        visited = new boolean[n];
        numbers = new int[n];
        nums = new int[n];
        result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        find(n, 0);
//        int[] answer = result.get((int)k - 1);
//        return answer;
    }

    public static void find(int n, int level) {
        if(n == level) {
            for(int i = 0; i < n; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                numbers[level] = nums[i];
                find(n, level + 1);
                visited[i] = false;
            }
        }
    }
}