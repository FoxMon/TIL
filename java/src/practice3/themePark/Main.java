package practice3.themePark;

import java.lang.*;
import java.util.*;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int map = scanner.nextInt();  // 지도의 크기
        int park = scanner.nextInt();  // 놀이공원의 크기
        int[][] wastes = new int[map][map]; // 각 칸의 쓰레기 존재 여부

        for (int r = 0; r < map; r += 1) {
            for (int c = 0; c < map; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        int current_col = 0;
        int current_row;
        int answer = Integer.MAX_VALUE;
        int min = 0;

        while((current_col + park) <= map) {
            current_row = 0;
            while((current_row + park) <= map) {
                min = check(wastes, park, current_col, current_row);
                current_row++;
            }

            if(answer >= min) {
                answer = min;
            }

            current_col++;
        }

        System.out.println(answer);
    }

    public static int check(int[][] wastes, int park, int current_col, int current_row) {
        int cnt = 0;

        for(int i = current_row; i < (park + current_row); i++) {
            for(int j = current_col; j < (park + current_col); j++) {
                if(wastes[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}