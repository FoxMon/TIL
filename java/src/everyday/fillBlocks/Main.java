package everyday.fillBlocks;

// 못했음
public class Main {
    static int[][] blocks;

    public static void fillLeft(int row, int col) {
        if(col < 0) {
            return;
        }
        blocks[row][col] = blocks[row - 1][col] - blocks[row][col + 1];
        fillLeft(row, col - 1);
    }

    public static void fillRight(int row, int col) {
        if(col > row) {
            return;
        }

        blocks[row][col] = blocks[row - 1][col - 1] + blocks[row][col - 1];
        fillRight(row, col + 1);
    }

    public static String solution(int[][] blocks) {
        String answer = "";
        blocks = new int[blocks.length][blocks.length];

        for(int i = 0; i < blocks.length; i++) {
            int col = blocks[i][0];
            int value = blocks[i][1];
            blocks[i][col] = value;
            fillLeft(i, col - 1);
            fillRight(i, col + 1);
        }

        for(int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length; j++) {
                answer += blocks[i][j] + " ";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a1 = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};
        System.out.println(solution(a1));

        int[][] a2 = {{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}};
        System.out.println(solution(a2));
    }

}
