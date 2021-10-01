package everyday.tableTennis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] c = new int[n];

        for(int i = 0; i < p.length; i++) {
            p[i] = scanner.nextInt();
        }

        for(int i = 0; i < c.length; i++) {
            c[i] = scanner.nextInt();
        }

        int price = 100;
        int count = 0;
        double result = 0;

        for(int i = 0; i < n && price >= 25; i++) {
            count += p[i];
            if(count >= c[i]) {
                result += price * c[i];
                count -= c[i];
                price = 100;
            } else {
                price /= 2;
            }
        }

        System.out.printf("%.2f", result / n);
    }
}
