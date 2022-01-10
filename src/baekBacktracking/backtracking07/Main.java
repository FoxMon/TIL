package baekBacktracking.backtracking07;

import java.util.Scanner;

public class Main {
    public static int numbers;
    public static boolean[] visited;
    public static int[] map;
    public static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.nextInt();
        map = new int[numbers];
        visited = new boolean[numbers];
        find(0);
        System.out.println(result);
    }

    private static void find(int level) {
        if(level == numbers) {
            result++;
            return;
        }

        for(int i = 0; i < numbers; i++) {
            if(!visited[i]) {
                visited[i] = true;
                map[level] = i;
                if(check(level)) {
                    find(level + 1);
                }
                visited[i] = false;
            }
        }
    }

    private static boolean check(int level) {
        for(int i = 0; i < level; i++) {
            if(map[level] == map[i]) {
                return false;
            }
            if(level - i == Math.abs(map[level] - map[i])) {
                return false;
            }
        }

        return true;
    }
}
