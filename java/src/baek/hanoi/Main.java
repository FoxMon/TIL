package baek.hanoi;

import java.util.Scanner;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int move = (int)Math.pow(2, target) - 1;
        stringBuilder.append(move + "\n");
        hanoi(target, 1, 2, 3);
        System.out.println(stringBuilder);
    }

    public static void hanoi(int target, int start, int middle, int destination) {
        if(target == 1) {
            stringBuilder.append(start + " " + destination + "\n");
            return;
        }

        hanoi(target - 1, start, destination, middle);
        stringBuilder.append(start + " " + destination + "\n");
        hanoi(target - 1, middle, start, destination);
    }
}
