package programmers.level3.changeWords02;

public class Solution {
    public static int answer = 0;
    public static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        backTracking(begin, target, 0, words);
        return answer;
    }

    public void backTracking(String start, String target, int level, String[] words) {
        if(start.equals(target)) {
            answer = level;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }

            int count = 0;

            for(int j = 0; j < start.length(); j++) {
                if(start.charAt(j) == words[i].charAt(j)) {
                    count++;
                }

                if(count == words[i].length() - 1) {
                    visited[i] = true;
                    backTracking(words[i], target, level + 1, words);
                    visited[i] = false;
                }
            }
        }
    }
}
