package programmers.level2.wires;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for(int k = 0; k < n - 1; k++) {
            list = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < wires.length; i++) {
                if(i != k) { // 하나씩 끊음
                    int first = wires[i][0];
                    int last = wires[i][1];
                    list[first].add(last);
                    list[last].add(first);
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    result.add(find(i, 0));
                }
            }

            answer = Math.min(answer, Math.abs(result.get(0) - result.get(1)));
        }
        return answer;
    }

    public int find(int start, int cnt) {
        visited[start] = true;
        cnt++;

        for(int node : list[start]) {
            if(!visited[node]) {
                cnt = find(node, cnt);
            }
        }

        return cnt;
    }
}
