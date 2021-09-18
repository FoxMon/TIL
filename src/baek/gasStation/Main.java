package baek.gasStation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long[] distance = new long[count - 1];
        long[] costs = new long[count];

        for(int i = 0; i < distance.length; i++) {
            distance[i] = scanner.nextLong();
        }

        for(int i = 0; i < costs.length; i++) {
            costs[i] = scanner.nextLong();
        }

        long sum = 0;
        long min = costs[0];

        for(int i = 0; i < distance.length; i++) {
            if(min > costs[i]) {
                min = costs[i];
            }

            sum += (distance[i] * min);
        }

        System.out.println(sum);
    }
}
