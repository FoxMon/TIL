package baek.keySet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int testCase = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCase; i++) {
            String input = scanner.nextLine();
            String[] data1 = input.split(" ");
            String[] data2 = input.split("");

            if(checkFirst(data1, set)) {
            } else if(checkSecond(data2, set, input)) {
            } else {
                stringBuilder.append(input + "\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public static boolean checkFirst(String[] word, Set<String> set) {
        for(int i = 0; i < word.length; i++) {
            String data = word[i];
            String temp = data.substring(0, 1).toUpperCase();

            if(!set.contains(temp)) {
                set.add(temp);

                for(int j = 0; j < word.length; j++) {
                    if(j == i) {
                        stringBuilder.append("[" + data.substring(0, 1) + "]" + data.substring(1) + " ");
                    } else {
                        stringBuilder.append(word[j] + " ");
                    }
                }

                stringBuilder.append("\n");
                return true;
            }
        }

        return false;
    }

    public static boolean checkSecond(String[] word, Set<String> set, String origin) {
        for(int i = 0; i < word.length; i++) {
            String data = word[i].toUpperCase();

            if(data.equals(" ")) {
                continue;
            }

            if(!set.contains(data)) {
                set.add(data);
                stringBuilder.append(origin.substring(0, i) + "[" + origin.substring(i, i + 1) + "]" + origin.substring(i + 1) + "\n");
                return true;
            }
        }

        return false;
    }
}
