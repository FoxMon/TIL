package programmers.level1.notExistNumber;

public class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        int total = 45;
        int result = 0;

        for(int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }

        answer = total - result;

        return answer;
    }
}
