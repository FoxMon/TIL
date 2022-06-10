package everyday.stringReSorting;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String current = scanner.next();
        String newString = "";
        int number = 0;

        for(int i = 0; i < current.length(); i++) {
            if(current.charAt(i) - '0' >= 0 && current.charAt(i) - '0' <= 9) {
                number += Integer.parseInt(current.charAt(i) + "");
            } else {
                newString += current.charAt(i) + "";
            }
        }

        String[] arrays = newString.split("");
        Arrays.sort(arrays);

        for(int i = 0; i < arrays.length; i++) {
            stringBuilder.append(arrays[i]);
        }

        if(number != 0) {
            System.out.println(stringBuilder.toString() + number);
        } else {
            System.out.println(stringBuilder.toString());
        }
    }
}
