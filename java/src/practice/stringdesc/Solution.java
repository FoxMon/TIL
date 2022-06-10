package practice.stringdesc;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for(int i = chars.length - 1; i >= 0; i--) {
            answer += chars[i] + "";
        }

        return answer;
    }
}
