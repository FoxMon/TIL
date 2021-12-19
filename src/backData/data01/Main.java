package backData.data01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listen = scanner.nextInt();
        int see = scanner.nextInt();
        int total = listen + see;
        ArrayList<String> results = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < total; i++) {
            String temp = scanner.next();

            if(!hashMap.containsKey(temp)) {
                hashMap.put(temp, i);
            } else {
                results.add(temp);
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        for(String result : results) {
            System.out.println(result + " ");
        }
    }
}
