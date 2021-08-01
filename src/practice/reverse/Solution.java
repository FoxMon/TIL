package practice.reverse;

public class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int[] answer = new int[str.length()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1 - i)));
        }

        return answer;
    }
}
