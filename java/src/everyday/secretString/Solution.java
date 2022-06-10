package everyday.secretString;

public class Solution {
    public String solution(String m, String k) {
        String answer = "";
        int index = 0;
        for(char c : m.toCharArray()) {
            if(index >= k.length() || c != k.charAt(index)) {
                answer += c;
            } else {
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String m = "acbbcdc";
        String k = "abc";
        Solution solution = new Solution();
        System.out.println(solution.solution(m, k));
    }
}
