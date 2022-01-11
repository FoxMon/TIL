package baekBacktracking.backtracking09re;

import java.util.Scanner;

public class Main {
    public static int number;
    public static int count;
    public static int answer;
    public static boolean[] visited;
    public static String[] words;

    public static void main(String[] args) { // a n t i c
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        count = scanner.nextInt();
        answer = 0;
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        if(count < 5) {
            System.out.println(0);
            System.exit(0);
        } else if(count == 26) {
            System.out.println(number);
            System.exit(0);
        }

        words = new String[number];

        for(int i = 0; i < number; i++) {
            String temp = scanner.next();
            temp = temp.replace("anta", "");
            temp = temp.replace("tica", "");
            words[i] = temp;
        }

        find(0, 0);
        System.out.println(answer);
    }

    public static void find(int alpha, int level) {
        if(level >= count - 5) {
            int result = 0;

            for(int i = 0; i < number; i++) {
                boolean flag = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }

        for(int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                find(i, level + 1);
                visited[i] = false;
            }
        }
    }
}
