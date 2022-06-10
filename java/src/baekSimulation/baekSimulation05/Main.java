package baekSimulation.baekSimulation05;

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

        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        findMax(0, 0);
        System.out.println(answer);
    }

    public static void findMax(int start, int level) {
        if(level == max) {
            int result = 0;

            for(int i = 0; i < people.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(visited[j]) {
                        int dis = Math.abs(people.get(i).getRow() - chicken.get(j).getRow())
                                + Math.abs(people.get(i).getCol() - chicken.get(j).getCol());
                        temp = Math.min(temp, dis);
                    }
                }
                result += temp;
            }

            answer = Math.min(answer, result);
            return;
        }

        for(int i = start; i < chicken.size(); i++) { // backtracking을 이런식으로도 응용이 가능하다 이말임.
            visited[i] = true;
            findMax(i + 1, level + 1);
            visited[i] = false;
        }
    }
}
