package practice3.gameCount;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        int sum = number * (number - 1) / 2;

        System.out.println(sum);
    }
}
