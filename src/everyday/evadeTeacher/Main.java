package everyday.evadeTeacher;

import java.util.Scanner;

public class Main {
    public static int size;
    public static char[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        map = new char[size][size];
    }
}
