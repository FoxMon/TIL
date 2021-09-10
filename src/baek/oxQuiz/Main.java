package baek.oxQuiz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        String[] answers = new String[cases];
        String answer;

        for(int i = 0; i < cases; i++) {
            answer = scanner.next();
            answers[i] = answer;
        }

        for(String quiz : answers) {
            System.out.println(getSocres(quiz));
        }
    }

    public static int getSocres(String answer) {
        if(answer.length() == 0) {
            if(answer.charAt(0) == 'O') {
                return 1;
            } else {
                return 0;
            }
        }

        int score = 1;
        int index = 1;
        int result = 0;

        if(answer.charAt(0) == 'O') {
            result = 1;
        }

        while(index < answer.length()) {
            if(answer.charAt(index) == 'O') {
                if(answer.charAt(index - 1) == answer.charAt(index)) {
                    score++;
                } else {
                    score = 1;
                }
                result += score;
            }

            index++;
        }

        return result;
    }
}
