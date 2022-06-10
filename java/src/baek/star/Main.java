package baek.star;

import java.util.Scanner;

public class Main {
    public static char[][] star;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int target = scanner.nextInt();
        star = new char[target][target];
        star(0, 0, target, false);

        for(int i = 0; i < star.length; i++) {
            for(int j = 0; j < star[i].length; j++) {
                stringBuilder.append(star[i][j]);
            }
            stringBuilder.append('\n');
        }
        System.out.print(stringBuilder);
    }

    static void star(int x, int y, int target, boolean isBlank) {
        if(isBlank) {
            for(int i = x; i < x + target; i++) {
                for(int j = y; j < y + target; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if(target == 1) {
            star[x][y] = '*';
            return;
        }

        int size = target / 3;
        int count = 0;

        for (int i = x; i < x + target; i += size) {
            for (int j = y; j < y + target; j += size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
