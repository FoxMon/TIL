package everyday.stringCompress02;

public class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i < s.length(); i++) {
            String compress = "";
            String prev = s.substring(0, i);
            int count = 1;

            for(int j = i; j < s.length(); j++) {
                int end = j + i < s.length() ? j + i : s.length() - 1;
                if(prev.equals(s.substring(j, end))) {
                    count++;
                } else {
                   compress += count >= 2 ? count + prev : prev;
                   count = 1;
                   prev = s.substring(j, end);
                }
            }

            compress += count >= 2 ? count + prev : prev;
            answer = Math.min(answer, compress.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        everyday.stringCompress.Solution solution = new everyday.stringCompress.Solution();
        System.out.println(solution.solution("ababcdcdababcdcd"));
    }
}
