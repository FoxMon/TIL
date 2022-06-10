package programmers.level3.findNetwork;

public class Solution {
    public static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                findNetwork(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void findNetwork(int start, int[][] computers) {
        visited[start] = true;

        for(int i = 0; i < computers.length; i++) {
            if(!visited[i] && computers[i][start] == 1) {
                findNetwork(i, computers);
            }
        }
    }
}
