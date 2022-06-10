package practice3.dividesum;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        int sum = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
