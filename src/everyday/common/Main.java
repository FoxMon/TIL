package everyday.common;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first;
        String second;
        char[] firstAlpha;
        char[] secondAlpha;

        while(scanner.hasNextLine()) {
            firstAlpha = new char[26];
            secondAlpha = new char[26];
            first = scanner.nextLine();
            second = scanner.nextLine();

            for(int i = 0; i < first.length(); i++) {
                firstAlpha[first.charAt(i) - 'a']++;
            }

            for(int i = 0; i < second.length(); i++) {
                secondAlpha[second.charAt(i) - 'a']++;
            }

            for(int i = 0; i < firstAlpha.length; i++) {
                int count = Math.min(firstAlpha[i], secondAlpha[i]);

                for(int j = 0; j < count; j++) {
                    System.out.print((char)(i + 'a'));
                }
            }
            System.out.println();
        }
    }
}
