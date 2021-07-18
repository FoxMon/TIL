package lv01.centerstring;

public class Solution {

    public String solution(String s) {

        String answer = "";
        Character center;

        if(s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            center = s.charAt(s.length() / 2);
            answer = center.toString();
        }

        return answer;
    }
}
