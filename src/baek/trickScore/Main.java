package baek.trickScore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sanner = new Scanner(System.in);
        int subjects = sanner.nextInt();
        int total = 0;
        int max = 0;
        int score;

        for (int i = 0; i < subjects; ++i) {
            score = sanner.nextInt();
            total += score;

            if (score > max) {
                max = score;
            }
        }
        double avg = 100.0 * total / max / subjects;
        System.out.printf("%.2f", avg);
    }
}
