package everyday.adventureGuild02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] people = new int[total];

        for(int i = 0; i < people.length; i++) {
            people[i] = scanner.nextInt();
        }

        Arrays.sort(people);
        int count = 0;
        int guildCount = 0;

        for(int number : people) {
            count++;

            if(count >= number) {
                count = 0;
                guildCount++;
            }
        }

        System.out.println(guildCount);
    }
}
