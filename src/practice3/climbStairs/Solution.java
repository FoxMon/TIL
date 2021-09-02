package practice3.climbStairs;

public class Solution {
    public int climbStairs(int n) {
        if(n < 1) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }

        int answer = 0;
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;

        for(int i = 2; i < steps.length; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        answer = steps[steps.length - 1];

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
