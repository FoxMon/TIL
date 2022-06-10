package practice.harshad;

public class Solution {

    public boolean solution(int x) {

        boolean answer = true;
        int temp = x;
        int sum = 0;

        while(temp >= 1) {
            sum += temp % 10;
            temp /= 10;
        }

        if(x % sum == 0) {
            return answer;
        } else {
            answer = false;
            return answer;
        }
    }
}
