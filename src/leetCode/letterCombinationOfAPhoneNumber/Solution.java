package leetCode.letterCombinationOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] str = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) { return new ArrayList<>(); }
        List<String> digit = new ArrayList<>();
        for(char ch : digits.toCharArray()) {
            digit.add(str[ch - '0']);
        }
        List<String> results = new ArrayList<>();
        combination(digit, results, new StringBuilder(), 0);
        return results;
    }

    private void combination(List<String> digit, List<String> results, StringBuilder current, int level) {
        if(level == digit.size()) {
            results.add(current.toString());
            return;
        }

        String combi = digit.get(level);
        for(int i = 0; i < combi.length(); i++) {
            current.append(combi.charAt(i));
            combination(digit, results, current, level + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
