package everyday.floorFIx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int horizon = scanner.nextInt();
        int vertical = 2;
        int[] floors = new int[horizon + 1];
        floors[1] = 1;
        floors[2] = 3;

        for(int i = 3; i <= horizon; i++) {
            floors[i] = (floors[i - 2] * 2 + floors[i - 1]) % 796796;
        }

        System.out.println(floors[horizon]);
    }
}
