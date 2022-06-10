package practice.attraction;

public class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long result = 0;

        for(int i = 1; i <= count; i++) {
            result += ((long)price * i);
        }

        if(money >= result) {
            answer = 0;
        } else {
            answer = result - money;
        }

        return answer;
    }
}
