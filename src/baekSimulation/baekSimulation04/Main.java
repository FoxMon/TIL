package baekSimulation.baekSimulation04;

import java.util.Scanner;

public class Main {
    public static int x;
    public static int y;
    public static int minX;
    public static int minY;
    public static int maxX;
    public static int maxY;
    public static int direction;
    public static int[] dy = { 1, 0, -1, 0 };
    public static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) { // north
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            x = y = 0;
            minX = maxX = minY = maxY = 0;
            direction = 0;
            String control = scanner.next();
            char[] controls = control.toCharArray();
            int result = simulate(controls);
            System.out.println(result);
        }
    }

    public static int simulate(char[] controls) {
        int result;

        for(int i = 0; i < controls.length; i++) {
            switch(controls[i]) {
                case 'F':
                    x += dx[direction];
                    y += dy[direction];
                    updateLocation();
                    break;

                case 'B':
                    x -= dx[direction];
                    y -= dy[direction];
                    updateLocation();
                    break;

                case 'L':
                    direction = direction -1 == -1 ? 3 : direction - 1;
                    break;

                case 'R':
                    direction = direction + 1 == 4 ? 0 : direction + 1;
                    break;
            }
        }
        result = (Math.abs(minX - maxX) * Math.abs(minY - maxY));
        return result;
    }

    public static void updateLocation() {
        maxX = Math.max(maxX, x);
        minX = Math.min(minX, x);
        maxY = Math.max(maxY, y);
        minY = Math.min(minY, y);
    }
}
