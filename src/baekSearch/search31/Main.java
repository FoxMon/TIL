package baekSearch.search31;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int numbers;
    public static int relation;
    public static int answer = -1;
    public static boolean[] visited;
    public static ArrayList<Integer>[] relations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.nextInt();
        visited = new boolean[numbers + 1];
        relations = new ArrayList[numbers + 1];
        int find1 = scanner.nextInt();
        int find2 = scanner.nextInt();
        relation = scanner.nextInt();

        for(int i = 1; i <= numbers; i++) {
            relations[i] = new ArrayList<>();
        }

        for(int i = 0; i < relation; i++) {
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            relations[first].add(last);
            relations[last].add(first);
        }

        findRelation(find1, find2, 0);
        System.out.println(answer);
    }

    public static void findRelation(int start, int last, int level) {
        if(start == last) {
            answer = level;
            return;
        }

        visited[start] = true;
        for(int i = 0; i < relations[start].size(); i++) {
            int count = relations[start].get(i);
            if(!visited[count]) {
                findRelation(count, last, level + 1);
            }
        }
    }
}
