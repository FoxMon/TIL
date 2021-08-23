package practice3.grade;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double score = 0;

        for(int i = 0; i < 3; i++) {
            score += scanner.nextDouble();
        }

        score /= 3;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String grade = check(score);

        System.out.println(decimalFormat.format(score)+ " " + grade);
    }

    public static String check(double score) {
        if(score >= 90) {
            return "A";
        } else if(score >= 80 && score < 90) {
            return "B";
        } else if(score >= 70 && score < 80) {
            return "C";
        } else if(score >= 60 && score < 70) {
            return "D";
        } else {
            return "F";
        }
    }
}
