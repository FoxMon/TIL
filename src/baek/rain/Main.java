package baek.rain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heigiht = scanner.nextInt();
        int width = scanner.nextInt();
        int[] rain = new int[width];
        int result = 0;

        for(int i = 0; i < rain.length; i++) {
            rain[i] = scanner.nextInt();
        }

        for(int i = 1; i < rain.length - 1; i++) {
            int left = rain[i];
            int right = rain[i];

            for(int j = 0; j < i; j++) {
                if(left < rain[j]) {
                    left = rain[j];
                }
            }

            for(int k = i + 1; k < rain.length; k++) {
                if(right < rain[k]) {
                    right = rain[k];
                }
            }

            int rainHeight = Math.min(right, left);

            if(rainHeight > rain[i]) {
                result += rainHeight - rain[i];
            }
        }

        System.out.println(result);
    }
}
