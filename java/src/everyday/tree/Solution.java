package everyday.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution { // 쌉어려움
    public static ArrayList<Integer[]>[] list;
    public static ArrayList<Integer> selected;

    public int[] solution(int n, int[][] edges) {
        int[] answer;
        selected = new ArrayList<>();
        list = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            int vertex1 = edges[i][0];
            int vertex2 = edges[i][1];
            list[vertex1].add(new Integer[] { vertex2, i });
            list[vertex2].add(new Integer[] { vertex1, i });
        }

        dfs(0, -1);
        answer = selected.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static int dfs(int currentVertex, int parentVertex) {
        int sub = 1;

        for(Integer[] next : list[currentVertex]) {
            if(next[0] != parentVertex) {
                int size = dfs(next[0], currentVertex);

                if(size % (list.length / 3) == 0) {
                    selected.add(next[1]);
                }

                sub += size;
            }
        }

        return sub;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a1 =  {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
        System.out.println(Arrays.toString(solution.solution(a1.length + 1, a1)));


        int[][] a2 =  {{0,1},{2,0}};
        System.out.println(Arrays.toString(solution.solution(a2.length + 1, a2)));
    }
}
