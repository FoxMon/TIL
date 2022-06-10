package baek.factorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int result = facotiral(target);
        System.out.println(result);
    }

    public static int facotiral(int number) {
        if(number <= 1) {
           return 1;
        }

        return facotiral(number - 1) * number;
    }
}
