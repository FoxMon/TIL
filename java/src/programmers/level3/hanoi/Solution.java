package programmers.level3.hanoi;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++) {
            int[] command = list.get(i);
            answer[i][0] = command[0];
            answer[i][1] = command[1];
        }

        return answer;
    }

    public static void hanoi(int n, int from, int to, int middle) {
        int[] move = { from, to };

        if(n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, middle, to);
            list.add(move);
            hanoi(n - 1, middle, to, from);
        }
    }
}
