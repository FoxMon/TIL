package everyday.adventureGuild;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int adventureCount = scanner.nextInt();
        int[] adventures = new int[adventureCount];

        for(int i = 0; i < adventures.length; i++) {
            adventures[i] = scanner.nextInt();
        }

        int group = 0;
        int count = 0;
        Arrays.sort(adventures);

        for(int adventure : adventures) {
            count++;

            if(count >= adventure) {
                count = 0;
                group++;
            }
        }

        System.out.println(group);
    }
}
