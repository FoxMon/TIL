package baek.josephus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        LinkedList<Integer> josephus = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            josephus.add(i);
        }

        int count = 0;

        while(!josephus.isEmpty()) {
            if(count == (k - 1)) {
                int target = josephus.removeFirst();
                result.add(target);
                count = 0;
            } else {
                int target = josephus.removeFirst();
                josephus.add(target);
                count++;
            }
        }

        System.out.print("<");
        for(int i = 0; i < result.size(); i++) {
            if(result.size() - 1 == i) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
        System.out.print(">");
    }
}
