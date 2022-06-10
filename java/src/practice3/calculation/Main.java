package practice3.calculation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operate;
        int op1, op2;

        op1 = scanner.nextInt();
        operate = scanner.next();
        op2 = scanner.nextInt();

        System.out.println(calculate(op1, op2, operate));
    }

    public static String calculate(int op1, int op2, String operate) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String result_string = "";
        int result = 0;

        switch(operate) {
            case "+":
                result = op1 + op2;
                result_string = Integer.toString(result);
                break;

            case "-":
                result = op1 - op2;
                result_string = Integer.toString(result);
                break;

            case "*":
                result = op1 * op2;
                result_string = Integer.toString(result);
                break;

            case "/":
                result = op1 / op2;
                result_string =  decimalFormat.format(result);
                break;
        }

        return result_string;
    }
}
