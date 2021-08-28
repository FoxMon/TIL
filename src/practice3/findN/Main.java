package practice3.findN;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        int start = 1;
        int sum = 0;

        while(sum <= number) {
            sum += start;
            start++;
        }

        start--;
        System.out.println(start);
    }
}
