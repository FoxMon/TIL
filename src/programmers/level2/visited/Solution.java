package programmers.level2.visited;

public class Solution {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static boolean[][][][] isVisited = new boolean[11][11][11][11];
    public static int currentX, currentY;
    public static int nextX, nextY;

    public int solution(String dirs) {
        int answer = 0;
        currentX = currentY = 5;
        nextX = nextY = 5;

        for(char move : dirs.toCharArray()) {
            currentX = nextX;
            currentY = nextY;

            if(move == 'U') {
                nextX = currentX + dx[2];
                nextY = currentY + dy[2];
            } else if(move == 'D') {
                nextX = currentX + dx[3];
                nextY = currentY + dy[3];
            } else if(move == 'R') {
                nextX = currentX + dx[1];
                nextY = currentY + dy[1];
            } else {
                nextX = currentX + dx[0];
                nextY = currentY + dy[0];
            }

            if(nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
                nextY = currentY;
                nextX = currentX;
                continue;
            }

            if(!isVisited[currentX][currentY][nextX][nextY]) {
                isVisited[currentX][currentY][nextX][nextY] = true;
                isVisited[nextX][nextY][currentX][currentY] = true;
                answer++;
            }
        }

        return answer;
    }
}
