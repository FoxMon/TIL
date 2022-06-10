package practice3.maxRectangle;

public class Solution {
    public static int solution(int[][] board) {
        int answer = 1;

        if(checkZero(board)) {
            return 0;
        }

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    continue;
                }

                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i -1][j - 1]) + 1;
                answer = Math.max(board[i][j], answer);
            }
        }

        answer *= answer;

        return answer;
    }

    public static boolean checkZero(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
