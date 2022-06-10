package baek.croatianWord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.next();
        String[] croatians = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for(int i = 0; i < croatians.length; i++) {
           if(words.contains(croatians[i])) {
               words = words.replaceAll(croatians[i], ".");
           }
        }

        System.out.println(words.length());
    }
}
