package practice3.sumArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int size2 = scanner.nextInt();
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = scanner.nextInt();
        }

        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] arr3 = new int[size1 + size2];

        for(int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++) {
            arr3[i + size1] = arr2[i];
        }

        Arrays.sort(arr3);

        for(int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
