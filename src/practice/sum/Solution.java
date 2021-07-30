package practice.sum;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String number = Integer.toString(n);

        for(int i = 0; i < number.length(); i++) {
            Character temp = number.charAt(i);
            answer += Integer.parseInt(temp.toString());
        }

        return answer;
    }
}
