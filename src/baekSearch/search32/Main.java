package baekSearch.search32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            int store = scanner.nextInt();
            ArrayList<Point> arrayList = new ArrayList<>();

            for(int i = 0; i < store + 2; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                arrayList.add(new Point(x, y));
            }

            if(find(arrayList)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean find(ArrayList<Point> temp) {
        Queue<Point> queue = new LinkedList<>();
        Point start = temp.get(0);
        Point end = temp.get(temp.size() - 1);
        queue.offer(start);
        boolean check = false;
        boolean[] visited = new boolean[temp.size()];
        visited[0] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            if(current.getX() == end.getX() && current.getY() == end.getY()) {
                check = true;
                break;
            }

            for(int i = 1; i < temp.size(); i++) {
                if(!visited[i] && Math.abs(current.getX() - temp.get(i).getX()) + Math.abs(current.getY() - temp.get(i).getY()) <= 1000) {
                    queue.offer(temp.get(i));
                    visited[i] = true;
                }
            }
        }

        return check;
    }
}
