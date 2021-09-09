package baek.wordSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] words = new String[count];

        for(int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if(word1.length() == word2.length()) {
                    return word1.compareTo(word2);
                } else {
                    return word1.length() - word2.length();
                }
            }
        });

        System.out.println(words[0]);

        for(int i = 1; i < words.length; i++) {
            if(!words[i - 1].equals(words[i])) {
                System.out.println(words[i]);
            }
        }
    }
}
