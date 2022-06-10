package programmers.level2.targetNumber;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public int dfs(int[] numbers, int target, int level, int sum) {
        if (level >= numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return dfs(numbers, target, level + 1, sum + numbers[level]) +
                dfs(numbers, target, level + 1, sum - numbers[level]);
    }
}
