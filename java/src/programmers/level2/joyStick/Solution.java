package programmers.level2.joyStick;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        int cursor = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            answer += count(name.charAt(i));
        }

        for(int i = 0; i < name.length(); i++) { // AAAB
            int next = i + 1;

            while(next < name.length() && name.charAt(next) == 'A') { // find continuos A
                next++;
            };

            int aCount = next - i - 1;
            int move = name.length() - aCount - 1;
            int min = Math.min(i, name.length() - next);
            cursor = Math.min(cursor, move + min);
        }

        return answer + cursor;
    }

    public int count(char alpha) {
        int start = Math.abs(alpha - 'A');
        int end = 'Z' - alpha + 1;
        return Math.min(start, end);
    }
}
