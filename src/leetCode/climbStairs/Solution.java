package leetCode.climbStairs;

// 1 -> 1
// 2 -> 2
// 3 -> 3
// 4 -> 1 1 1 1, 1 2 1, 2 2, 1 1 2, 2 1 1 -> 5

public class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int[] step = new int[n + 1];
        step[1] = 1;
        step[2] = 2;

        for(int i = 3; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }

        return step[n];
    }
}