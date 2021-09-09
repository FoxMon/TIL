package baek.maxIndex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[9];

        for(int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        int max = a[0];
        int index = 1;

        for(int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
                index = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}