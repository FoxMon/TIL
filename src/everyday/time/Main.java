package everyday.time;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int count = 0;

        for(int i = 0; i < time + 1; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    String temp = Integer.toString(i) + j + k;
                    if(temp.contains("3")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
