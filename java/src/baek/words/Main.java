package baek.words;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        int[] alpha = new int[26];

        for(int i = 0; i < alpha.length; i++) {
            alpha[i] = 0;
        }

        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            alpha[character - 'a']++;
        }

        int max = alpha[0];
        int index = 0;

        for(int i = 1; i < alpha.length; i++) {
            if(max <= alpha[i]) {
                max = alpha[i];
                index = i;
            }
        }

        int count = 0;

        for(int i = 0; i < alpha.length; i++) {
            if(max == alpha[i]) {
                count++;
            }
        }

        if(count > 1) {
            System.out.println("?");
        } else {
            int ch = 'a' + index;
            String str = (char)ch + "";
            System.out.println(str.toUpperCase());
        }
    }
}
