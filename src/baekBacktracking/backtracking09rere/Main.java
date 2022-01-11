package baekBacktracking.backtracking09rere;

import java.util.Scanner;

public class Main {
    public static int number;
    public static int count;
    public static boolean[] visited;
    public static String[] words;
    public static int answer;

    public static void main(String[] args) { // a n t i c
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        count = scanner.nextInt();
        visited = new boolean[26];
        answer = 0;
        words = new String[number];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for(int i = 0; i < number; i++) {
            String temp = scanner.next();
            temp = temp.replace("anta", "");
            temp = temp.replace("tica", "");
            words[i] = temp;
        }

        find(0, 0);
        System.out.println(answer);
    }

    private static void find(int alpha, int level) {
        if(level >= count - 5) {
            int result = 0;

            for(int i = 0; i < number; i++) {
                boolean check = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!visited[words[i].charAt(j) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(alpha + i, level + 1);
                visited[i] = false;
            }
        }
    }
}
