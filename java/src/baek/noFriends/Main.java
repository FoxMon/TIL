package baek.noFriends;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.next();
        String target = scanner.next();
        String temp = "";

        for(int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) >= '0' && origin.charAt(i) <= '9') {
                continue;
            } else {
                temp += origin.charAt(i);
            }
        }

        if(temp.contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
