package programmers.level1.notEnoughMoney;

public class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        long result = 0;

        for(int i = 0; i < count; i++) {
            result += price * (i + 1);
        }

        if(result >= answer) {
            answer = Math.abs(result - answer);
        } else {
            answer = 0;
        }

        return answer;
    }
}
