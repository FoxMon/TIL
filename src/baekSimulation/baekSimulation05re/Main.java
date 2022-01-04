package baekSimulation.baekSimulation05re;

import java.util.ArrayList;
import java.util.Scanner;

class Map {
    private int row;
    private int col;

    public Map(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return this.row; }
    public int getCol() { return this.col; }
}

public class Main {
    public static int size;
    public static int max;
    public static int answer;
    public static boolean[] visited;
    public static int[][] map;
    public static ArrayList<Map> people = new ArrayList<>();
    public static ArrayList<Map> chicken = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        max = scanner.nextInt();
        map = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 1) {
                    people.add(new Map(i, j));
                } else if(map[i][j] == 2) {
                    chicken.add(new Map(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        answer = Integer.MAX_VALUE;
        findChick(0, 0);
        System.out.println(answer);
    }

    public static void findChick(int start, int level) {
        if(level == max) {
            int result = 0;

            for(int i = 0; i < people.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(visited[j]) {
                        int dis = Math.abs(people.get(i).getRow() - chicken.get(j).getRow()) +
                                Math.abs(people.get(i).getCol() - chicken.get(j).getCol());
                        temp = Math.min(temp, dis);
                    }
                }
                result += temp;
            }
            answer = Math.min(result, answer);
            return;
        }

        for(int i = start; i < visited.length; i++) {
            visited[i] = true;
            findChick(i + 1, level + 1);
            visited[i] = false;
        }
    }
}
