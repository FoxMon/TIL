package baek.dpTax;

import java.util.Scanner;

public class Main {
    public static int[] taxDP = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // A(n) = A(n-1) + A(n-2)
        taxDP[0] = 0;
        taxDP[1] = 1;
        taxDP[2] = 2;

        for(int i = 3; i < taxDP.length; i++) {
            taxDP[i] = -1;
        }

        System.out.println(makeTax(number));
    }

    public static int makeTax(int target) {
        if(taxDP[target] == -1) {
            taxDP[target] = makeTax(target - 1) + makeTax(target - 2);
        }

        return taxDP[target] % 15746;
    }
}
