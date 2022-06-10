package baek.sortInside;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] number = scanner.next().split("");
        Arrays.sort(number);

        for(int i = number.length-1; i >= 0; i--) {
            System.out.print(number[i]);
        }
    }
}
