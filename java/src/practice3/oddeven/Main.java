package practice3.oddeven;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);

        if(check(number)) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }

    public static boolean check(int number) {
        if(number % 2 == 0) {
            return true;
        }

        return false;
    }
}
