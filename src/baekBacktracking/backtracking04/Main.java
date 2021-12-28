package baekBacktracking.backtracking04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int number;
    public static int possible;
    public static boolean[] visited;
    public static String[] password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        possible = scanner.nextInt();
        visited = new boolean[possible];
        password = new String[possible];

        for(int i = 0; i < possible; i++) {
            password[i] = scanner.next().charAt(0) + "";
        }

        Arrays.sort(password);
        find(0, 0);
    }

    public static void find(int start, int level) {
        if(level == number) {
            int vowel = 0;
            int con = 0;
            String result = "";

            for(int i = 0; i < possible; i++) {
                if(visited[i]) {
                    result += password[i];
                    if(password[i].equals("a") || password[i].equals("e") || password[i].equals("i") ||
                        password[i].equals("o") || password[i].equals("u")) {
                        vowel++;
                    } else {
                        con++;
                    }
                }
            }

            if(vowel >= 1 && con >= 2) {
                System.out.println(result);
            }
        }

        for(int i = start; i < possible; i++) {
            visited[i] = true;
            find(i + 1, level + 1);
            visited[i] = false;
        }
    }
}
