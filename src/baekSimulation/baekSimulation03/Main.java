package baekSimulation.baekSimulation03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] words = new char[5][15];

        for(int i = 0 ; i < words.length; i++) {
            String temp = scanner.next();
            for(int j = 0; j < temp.length(); j++) {
                words[i][j] = temp.charAt(j);
            }
        }

        String result = "";

        for(int i = 0; i < words[0].length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(words[j][i] != '\0') {
                    result += words[j][i];
                }
            }
        }

        for(char ch : result.toCharArray()) {
            if(ch == ' ' || ch == '\0') {
                continue;
            }
            System.out.print(ch);
        }
    }
}
