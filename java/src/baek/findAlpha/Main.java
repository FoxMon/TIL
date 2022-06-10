package baek.findAlpha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int[] alpha = new int[26];

        for(int i = 0; i < alpha.length; i++) {
            alpha[i] = -1;
        }

        for(int i = 0; i < word.length(); i++) {
            char find = word.charAt(i);
            int index = find - 'a';

            if(alpha[index] == -1) {
                alpha[index] = i;
            }
        }

        for(int i = 0; i < alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
