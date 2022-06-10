package backData.data03;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            int first = scanner.nextInt();
            HashMap<Integer, Boolean> firstCheck = new HashMap<>();

            for(int i = 0; i < first; i++) {
                firstCheck.put(scanner.nextInt(), true);
            }

            int last = scanner.nextInt();

            for(int i = 0; i < last; i++) {
                int check = scanner.nextInt();
                if(firstCheck.containsKey(check)) {
                    stringBuilder.append(1 + "\n");
                } else {
                    stringBuilder.append(0 + "\n");
                }
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
