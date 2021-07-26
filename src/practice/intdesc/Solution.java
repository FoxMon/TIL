package practice.intdesc;

import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        String temp = String.valueOf(n);
        Character c[] = new Character[temp.length()];

        for(int i = 0; i < temp.length(); i++) {
            c[i] = temp.charAt(i);
        }
        Arrays.sort(c);
        String ansnum = "";
        for(int i = c.length - 1; i >= 0; i--) {
            ansnum += c[i];
        }
        answer = Long.parseLong(ansnum);
        return answer;
    }
}
