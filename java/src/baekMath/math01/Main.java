package baekMath.math01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        while(testCase-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            System.out.println(makeTurret(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int makeTurret(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int)Math.pow(x2 - x1, 2) + (int)Math.pow(y2 - y1, 2);

        if(x1 == x2 && y1 == y2 && r1 == r2) { // 접점 무한
            return -1;
        } else if(distance > Math.pow(r1 + r2, 2)) { // 반지름보다 큼
            return 0;
        } else if(distance < Math.pow(r2 - r1, 2)) { // 내접 x
            return 0;
        } else if(distance == Math.pow(r2 - r1, 2)) { // 내접
            return 1;
        } else if(distance == Math.pow(r2 + r1, 2)) { // 외접
            return 1;
        } else {
            return 2;
        }
    }
}
