package baek.dpPadovan;

import java.util.Scanner;

public class Main {
    public static long[] padovan = new long[101];
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();

        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;

        for(int i = 4; i < padovan.length; i++) {
            padovan[i] = -1;
        }

        while(test-- > 0) {
            int target = scanner.nextInt();
            stringBuilder.append(getPadovan(target) + "\n");
        }

        System.out.println(stringBuilder.toString());
    }

    public static long getPadovan(int target) {
        if(padovan[target] == -1) {
            padovan[target] = getPadovan(target - 3) + getPadovan(target - 2);
        }

        return padovan[target];
    }
}
