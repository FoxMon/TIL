package programmers.level3.changeWords;

public class Solution {
    public static boolean[] visited;
    public static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int level) {
        if(begin.equals(target)) {
            answer = level;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(visited[i]) {
                continue;
            }

            int count = 0;

            for(int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    count++;
                }
            }

            if(count == words[i].length() - 1) { // back tracking
                visited[i] = true;
                dfs(words[i], target, words, level + 1);
                visited[i] = false;
            }
        }
    }
}
