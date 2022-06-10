package baek.numberOfWords;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String context = scanner.nextLine();
        context = context.trim();
        String[] words = context.split(" ");
        if(context.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(words.length);
        }
    }
}
