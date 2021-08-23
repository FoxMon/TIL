package practice3.prime;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);

        if(isPrime(number)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean isPrime(int number) {
        int cnt = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                cnt++;
            }
        }

        if(cnt == 2) {
            return true;
        }

        return false;
    }
}
