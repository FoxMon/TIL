package everyday.stringCompress;

public class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i < s.length() / 2 + 1; i++) {
            String compress = "";
            String prev = s.substring(0, i);
            int count = 1;

            for(int j = i; j < s.length(); j += i) {
                int end = j + i < s.length() ? j + i : s.length();
                if(prev.equals(s.substring(j, end))) {
                    count++;
                } else {
                    compress += count >= 2 ? Integer.toString(count) + prev : prev;
                    prev = s.substring(j, end);
                    count = 1;
                }
            }

            compress += count >= 2 ? Integer.toString(count) + prev : prev;
            answer = Math.min(answer, compress.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ababcdcdababcdcd"));
    }
}
