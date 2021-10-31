package programmers.level2.callbook;

import java.util.LinkedList;
import java.util.Queue;

class Book {
    private int bookRow;
    private int bookCol;

    public Book(int tempRow, int tempCol) {
        this.bookRow = tempRow;
        this.bookCol = tempCol;
    }

    public int getRow() { return this.bookRow; }
    public int getCol() { return this.bookCol; }
}

public class Solution {
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    public static int row;
    public static int col;
    public static long color;
    public static boolean[][] visited;
    public static int numberOfArea;
    public static int maxSizeOfOneArea;

    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        row = m;
        col = n;
        color = 0;
        long[][] books = new long[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                books[i][j] = (long)picture[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(books[i][j] != 0 && !visited[i][j]) {
                    color = books[i][j];
                    findSize(i, j, books);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void findSize(int mapRow, int mapCol, long[][] books) {
        Queue<Book> queue = new LinkedList<>();
        queue.offer(new Book(mapRow, mapCol));
        visited[mapRow][mapCol] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            Book current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int currentRow = current.getRow() + dy[i];
                int currentCol = current.getCol() + dx[i];

                if(currentRow >= 0 && currentCol >= 0 && currentRow < row && currentCol < col) {
                    if(color == books[currentRow][currentCol] && !visited[currentRow][currentCol]) {
                        queue.offer(new Book(currentRow, currentCol));
                        visited[currentRow][currentCol] = true;
                        count++;
                    }
                }
            }
        }

        numberOfArea++;
        maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
    }
}
