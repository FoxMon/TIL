package programmers.level3.nqueen;

public class Solution {
    public static boolean[] visited;
    public static int[] locate;
    public static int answer;

    public int solution(int n) {
        answer = 0;
        visited = new boolean[n];
        locate = new int[n];
        evadeQueen(0, n);
        return answer;
    }

    public static void evadeQueen(int level, int target) {
        if(level == target) {
            answer++;
            return;
        }

        for(int i = 0; i < target; i++) {
            if(!visited[i]) {
                visited[i] = true;
                locate[level] = i; // row, col
                if(checkLocation(level)) {
                    evadeQueen(level + 1, target);
                }
                visited[i] = false;
            }
        }
    }

    public static boolean checkLocation(int level) {
        for(int i = 0; i < level; i++) {
            if(locate[i] == locate[level]) { // same row
                return false;
            }

            if(Math.abs(level - i) == Math.abs(locate[level] - locate[i])) { // same cross
                return false;
            }
        }

        return true;
    }
}