package baekBacktracking.backtracking04re;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int password;
    public static int possible;
    public static boolean[] visited;
    public static String[] passwords;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        password = scanner.nextInt();
        possible = scanner.nextInt();
        visited = new boolean[possible];
        passwords = new String[possible];

        for(int i = 0; i < possible; i++) {
            passwords[i] = scanner.next().charAt(0) + "";
        }

        Arrays.sort(passwords);
        find(0, 0);
    }

    public static void find(int start, int level) {
        if(level == password) {
            int vowel = 0;
            int con = 0;
            String result = "";

            for(int i = 0; i < possible; i++) {
                if(visited[i]) {
                    result += passwords[i];

                    if(passwords[i].equals("a") || passwords[i].equals("e") || passwords[i].equals("i") ||
                            passwords[i].equals("o") || passwords[i].equals("u")) {
                        vowel++;
                    } else {
                        con++;
                    }
                }
            }

            if(vowel >= 1 && con >= 2) {
                System.out.println(result);
            }

            return;
        }

        for(int i = start; i < possible; i++) {
            visited[i] = true;
            find(i + 1, level + 1);
            visited[i] = false;
        }
    }
}
