package baek.iSharp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String variable = scanner.nextLine();
        String start = variable.split(" ")[0];
        String[] variables = variable.split(" ");
        int len = variables.length - 1;
        String[] answers = new String[len];
        String[] names = new String[len];
        int count = 0;

        for(int i = 1; i < variables.length; i++) {
            String name = variables[i];
            name = name.replace(",", "");
            answers[count] = "";
            names[count] = "";

            if(i == variables.length - 1) {
                name = name.replace(";", "");
            }

            for(int j = name.length() - 1; j >= 0; j--) {
                if(name.charAt(j) == '*' || name.charAt(j) == '&') {
                    answers[count] += name.charAt(j) + "";
                } else if(name.charAt(j) == ']') {
                    answers[count] += "[]";
                    j--;
                } else {
                    for(int k = 0; k <= j; k++) {
                        names[count] += name.charAt(k);
                    }
                    names[count] += ";";
                    break;
                }
            }
            answers[count] = start + answers[count] + " " + names[count];
            count++;
        }

        for(String answer : answers) {
            System.out.println(answer);
        }
    }
}
