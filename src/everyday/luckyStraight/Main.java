package everyday.luckyStraight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringScore = scanner.next();
        int halfIndex = stringScore.length() / 2;
        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0; i < stringScore.length() / 2; i++) {
            leftSum += Integer.parseInt(stringScore.charAt(i) + "");
            int half = stringScore.length()/2 + i;
            rightSum += Integer.parseInt(stringScore.charAt(half) + "");
        }

        if(leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
