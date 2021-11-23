package baek.arraySum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int sizeA = scanner.nextInt();
        int sizeB = scanner.nextInt();
        int[] firstArr = new int[sizeA];
        int[] secondArr = new int[sizeB];

        for(int i = 0; i < sizeA; i++) {
            firstArr[i] = scanner.nextInt();
        }

        for(int i = 0; i < sizeB; i++) {
            secondArr[i] = scanner.nextInt();
        }

        ArrayList<Integer> results = new ArrayList<>();

        for(int number : firstArr) {
            results.add(number);
        }

        for(int number : secondArr) {
            results.add(number);
        }

        Collections.sort(results);

        for(int number : results) {
            stringBuilder.append(number + " ");
        }

        System.out.print(stringBuilder.toString());
    }
}
