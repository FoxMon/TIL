package practice.pandy;

public class Solution {
    boolean solution(String s) {
        boolean answer = false;
        String str = s.toLowerCase();
        int p_cnt = 0;
        int y_cnt = 0;

        for(int i = 0; i < s.length(); i++) {
            if(str.charAt(i) == 'p') {
                p_cnt++;
            } else if(str.charAt(i) == 'y') {
                y_cnt++;
            }
        }

        if(p_cnt == y_cnt) {
            answer = true;
        }

        return answer;
    }
}
