package everyday.adventureGuild03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] players = new int[total];

        for(int i = 0; i < total; i++) {
            players[i] = scanner.nextInt();
        }

        Arrays.sort(players);

        int scare = 0;
        int count = 0;

        for(int player : players) {
            count++;
            if(player <= count) {
                scare++;
                count = 0;
            }
        }

        System.out.println(scare);
    }
}
