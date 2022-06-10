package everyday.test;

public class Solution {
    public long[] solution(String s, String op) {
        long[] answer = new long[s.length() - 1];

        for(int i = 0; i < s.length(); i++) {
            long left = Integer.parseInt(s.charAt(i) + "");
            long right = Integer.parseInt(s.substring(i + 1));
            answer[i] = getResult(left, right, op);
        }

        return answer;
    }

    private long getResult(long left, long right, String op) {
        switch(op) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
