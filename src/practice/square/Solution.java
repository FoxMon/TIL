package practice.square;

public class Solution {
    public long solution(long n) {
        long answer = (long)Math.sqrt(n);

        if(answer * answer == n) {
            answer += 1;
            answer *= answer;
        } else {
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.solution(111);
        System.out.println(result);
    }
}
