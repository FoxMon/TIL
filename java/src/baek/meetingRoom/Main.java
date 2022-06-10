package baek.meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int count = 0;
        int endTime = 0;
        int[][] users = new int[input][2];

        for(int i = 0; i < input; i++) {
            users[i][0] = scanner.nextInt();
            users[i][1] = scanner.nextInt();
        }

        Arrays.sort(users, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < input; i++) {
            if(endTime <= users[i][0]) {
                endTime = users[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
