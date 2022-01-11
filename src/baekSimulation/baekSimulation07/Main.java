package baekSimulation.baekSimulation07;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int answer = 0;
        String[] words = new String[count];

        for(int i = 0; i < count; i++) {
            words[i] = scanner.next();
        }

        Arrays.sort(words);
        for(int i = 0; i < words.length; i++) {
            boolean flag = false;
            for(int j = i + 1; j < words.length; j++) {
                if(words[j].startsWith(words[i])) {
                    flag = true;
                }
            }
            if(!flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
