package practice3.reverseString;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String reverse = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i) + "";
        }

        System.out.println(reverse);
    }
}
