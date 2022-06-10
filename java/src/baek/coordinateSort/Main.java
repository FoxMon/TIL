package baek.coordinateSort;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    @Override
    public int compareTo(Point o) {
        if(this.x != o.getX()) {
            if(this.x < o.getX()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if(this.y < o.getY()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        Point[] points = new Point[testCase];

        for(int i = 0; i < testCase; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        Arrays.sort(points);

        for(Point point : points) {
            System.out.println(point.getX() + " " + point.getY());
        }
    }
}
