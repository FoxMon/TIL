package practice2.primenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int sum = 0;

        for(int i = first; i <= second; i++) {
            if(isPrime(i)) {
                sum += i;
                arrayList.add(i);
            }
        }

        if(sum == 0) {
            sum = -1;
            System.out.println(sum);
            return;
        } else {
            System.out.println(sum);
            Collections.sort(arrayList);
            System.out.println(arrayList.get(0));
        }
    }

    public static boolean isPrime(int num) {
        int cnt = 0;

        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                cnt++;
            }
        }

        if(cnt == 2) {
            return true;
        }

        return false;
    }
}
