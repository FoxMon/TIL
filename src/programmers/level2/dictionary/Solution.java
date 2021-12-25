package programmers.level2.dictionary;

public class Solution {
    public int solution(String word) {
        int answer = word.length();
        int[] x = {781, 156, 31, 6, 1};
        String str = "AEIOU";

        for (int i=0; i<word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += x[i] * idx;
            System.out.println(answer);
        }

        return answer;
    }
}
