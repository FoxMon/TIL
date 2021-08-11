package practice2.easyquestion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] input = new int[2];
        int number = 1;
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }

        while(number != 1000) {
            if(cnt != number) {
                arrayList.add(number);
                cnt++;
            } else {
                cnt = 0;
                number++;
            }
        }

        for(int i = input[0]; i <= input[1]; i++) {
            sum += arrayList.get(i - 1);
        }

        System.out.println(sum);
    }
}
