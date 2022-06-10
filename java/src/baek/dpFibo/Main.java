package baek.dpFibo;

import java.util.Scanner;

public class Main {
    public static Integer[][] fiboDp = new Integer[41][2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int caseCount = scanner.nextInt();

        fiboDp[0][0] = 1;
        fiboDp[0][1] = 0;
        fiboDp[1][0] = 0;
        fiboDp[1][1] = 1;

        while(caseCount > 0) {
            int number = scanner.nextInt();
            fibo(number);
            stringBuilder.append(fiboDp[number][0] + " " + fiboDp[number][1] + "\n");
            caseCount--;
        }

        System.out.println(stringBuilder.toString());
    }

    public static Integer[] fibo(int number) {
        if(fiboDp[number][0] == null || fiboDp[number][1] == null) {
            fiboDp[number][0] = fibo(number - 1)[0] + fibo(number - 2)[0];
            fiboDp[number][1] = fibo(number - 1)[1] + fibo(number - 2)[1];
        }

        return fiboDp[number];
    }
}
