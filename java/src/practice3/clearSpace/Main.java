package practice3.clearSpace;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String noSpace = "";

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' ') {
                noSpace += input.charAt(i) + "";
            }
        }

        System.out.println(noSpace);
    }
}
