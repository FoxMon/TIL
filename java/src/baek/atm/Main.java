package baek.atm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPeople = scanner.nextInt();
        int toatalTime = 0;
        int[] people = new int[totalPeople];
        int[] peopleTime = new int[totalPeople];

        for(int i = 0; i < people.length; i++) {
            people[i] = scanner.nextInt();
        }
        int result = 0;

        Arrays.sort(people);

        for(int i = 0; i < people.length; i++) {
            toatalTime += people[i];
            peopleTime[i] = toatalTime;
            result += peopleTime[i];
        }

        System.out.println(result);
    }
}
