package practice3.leapYear;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int year = Integer.parseInt(input);

        if(year % 4 == 0 && year % 400 == 0) {
            System.out.println("Leap Year");
        } else if(year % 4 == 0 && year % 100 == 0) {
            System.out.println("Not Leap Year");
        } else if(year % 4 == 0) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not Leap Year");
        }
    }
}
