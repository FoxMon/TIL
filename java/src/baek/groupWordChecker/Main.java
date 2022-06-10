package baek.groupWordChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int word_count = scanner.nextInt();
        String[] words = new String[word_count];

        for(int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }

        for(int i = 0; i < words.length; i++) {
            if(isGroupWord(words[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGroupWord(String word) {
        boolean[] alpha = new boolean[26];
        int prev = 0;
        int curr;

        for(int i = 0; i < word.length(); i++) {
            curr = word.charAt(i);
            if(prev != curr) {
                if(!alpha[curr - 'a']) {
                    alpha[curr - 'a'] = true;
                    prev = curr;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
