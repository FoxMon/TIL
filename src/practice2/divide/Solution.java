package practice2.divide;

import java.util.Scanner;

public class Solution {
    public static int n, k;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        n = scanner.nextInt();
        k = scanner.nextInt();

        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                k--;
            }

            if(k == 0) {
                System.out.println(i);
                break;
            }
        }

        if(k != 0) {
            System.out.println(0);
        }
    }
}
