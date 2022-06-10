package programmers.level2.repeatBinary;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String result = s;
        int change = 0;
        int count = 0;

        while(result.length() != 1) {
            count += checkZero(result);
            result = result.replace("0", "");
            int len = result.length();
            result = Integer.toBinaryString(len);
            change++;
        }
        answer[0] = change;
        answer[1] = count;

        return answer;
    }

    public int checkZero(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                count++;
            }
        }

        return count;
    }
}
