package practice.cranegame;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> results = new Stack<>();
        int answer = 0;
        results.push(0);

        for(int move : moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][move - 1] != 0) {
                    if(results.peek() == board[j][move - 1]) {
                        results.pop();
                        answer += 2;
                    } else {
                        results.push(board[j][move - 1]);
                    }

                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
