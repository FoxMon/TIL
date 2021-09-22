package baek.virus;

import java.util.Scanner;

public class Main {
    public static boolean[] isVisited;
    public static int[][] computer;
    public static int computerCount;
    public static int networkCount;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        computerCount = scanner.nextInt();
        networkCount = scanner.nextInt();
        computer = new int[computerCount + 1][computerCount + 1];
        isVisited = new boolean[computerCount + 1];

        for(int i = 0; i < networkCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            computer[x][y] = computer[y][x] = 1;
        }

        System.out.println(visit(1));
    }

    public static int visit(int start) {
        isVisited[start] = true;

        for(int i = 1; i <= computerCount; i++) {
            if(computer[start][i] == 1 && !isVisited[i]) {
                count++;
                visit(i);
            }
        }

        return count;
    }
}
