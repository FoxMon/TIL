package practice3.game369;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);
        int count = 0;

        for(int i = 1; i < num; i++) {
            String number = Integer.toString(i);
            count += checkNumber(number);
        }

        System.out.println(count);
    }

    public static int checkNumber(String number) {
        int cnt = 0;

        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '3' || number.charAt(i) == '6' || number.charAt(i) == '9') {
                cnt++;
            }
        }

        return cnt;
    }
}
