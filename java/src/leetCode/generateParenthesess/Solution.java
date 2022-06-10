package leetCode.generateParenthesess;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generate(answer, "", 0, 0, n);
        return answer;
    }

    private void generate(List<String> answer, String bracket, int open, int close, int max) {
        if(bracket.length() == max * 2) {
            answer.add(bracket);
            return;
        }

        if(open < max) { generate(answer, bracket + "(", open + 1, close, max); }
        if(close < open) { generate(answer, bracket + ")", open, close + 1, max); }
    }
}
