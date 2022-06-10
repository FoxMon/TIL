package practice2.targetnumber;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);

        return answer;
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) {
                return 1;
            }

            return 0;
        }

        return dfs(numbers, target, index + 1, sum + numbers[index]) +
                dfs(numbers, target, index + 1, sum - numbers[index]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
