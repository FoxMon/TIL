package baek.lostBracket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String express = scanner.nextLine();
        String[] subtract = express.split("-");
        int sum = Integer.MAX_VALUE;

        for(int i = 0; i < subtract.length; i++) {
            int tempSum = 0;
            String[] add = subtract[i].split("\\+");

            for(int j = 0; j < add.length; j++) {
                tempSum += Integer.parseInt(add[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = tempSum;
            } else {
                sum -= tempSum;
            }
        }

        System.out.println(sum);
    }
}
