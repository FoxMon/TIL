package baek.reverseString01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int count = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < count; i++) {
            String str = scanner.nextLine();
            String[] strings = str.split(" ");

            for(int j = 0; j < strings.length; j++) {
                stringBuilder.append(reverse(strings[j]) + " ");
            }
            System.out.println(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }
    }

    private static String reverse(String string) {
        String reverse = "";

        for(int i = 0; i < string.length(); i++) {
            reverse += string.charAt(string.length() - 1 - i);
        }

        return reverse;
    }
}
