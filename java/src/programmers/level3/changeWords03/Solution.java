package programmers.level3.changeWords03;

public class Solution {
    public static int answer = 0;
    public static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        changeWord(begin, target, words, 0);
        return answer;
    }

    public static void changeWord(String begin, String target, String[] words, int level) {
        if(begin.equals(target)) {
            answer = level;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            int count = 0;
            if(!visited[i]) {
                for(int j = 0; j < words[i].length(); j++) {
                    if(begin.charAt(j) == words[i].charAt(j)) {
                        count++;
                    }
                }

                if(count == words[i].length() - 1) {
                    visited[i] = true;
                    changeWord(words[i], target, words, level + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
