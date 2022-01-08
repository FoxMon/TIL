package programmers.level2.dungeon;

public class Solution {
    public static boolean[] visited;
    public static int tired;
    public static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        join(dungeons, k, 0);
        return answer;
    }

    public void join(int[][] dungeons, int k, int level) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    join(dungeons, k - dungeons[i][1], level + 1);
                    visited[i] = false;
                }
            }
        }
        answer = Math.max(answer, level);
    }
}
