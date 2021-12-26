package baekString.string05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            int dirNumber = scanner.nextInt();
            String[] directory = new String[dirNumber];

            for(int j = 0; j < dirNumber; j++) {
                directory[j] = scanner.next();
            }

            Arrays.sort(directory); // Sort -> 123, 1234, ..... good idea
            if(check(directory)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean check(String[] directory) {
        for(int i = 0; i < directory.length - 1; i++) {
            if(directory[i + 1].startsWith(directory[i])) {
                return false;
            }
        }

        return true;
    }
}
