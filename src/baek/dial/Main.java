package baek.dial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] requires = input.split("");
        int sum = 0;

        for(int i = 0; i < requires.length; i++) {
            sum += getDial(requires[i]);
        }

        System.out.println(sum);
    }

    public static int getDial(String dial) {
        switch (dial) {
            case "A": case "B": case "C":
                return 3;

            case "D": case "E": case "F":
                return 4;

            case "G": case "H": case "I":
                return 5;

            case "J": case "K": case "L":
                return 6;

            case "M": case "N": case "O":
                return 7;

            case "P": case "Q": case "R": case "S":
                return 8;

            case "T": case "U": case "V":
                return 9;

            case "W": case "X": case "Y": case "Z":
                return 10;

            default :
                return 11;
        }
    }
}
