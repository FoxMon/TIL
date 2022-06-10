package baek.extension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] files = new String[count];
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < files.length; i++) {
            files[i] = scanner.next();
            String file = files[i].split("\\.")[1];

            if(!map.containsKey(file)) {
                map.put(file, 1);
            } else {
                int value = map.get(file);
                value++;
                map.replace(file, value);
            }
        }

        String[] arr = new String[map.size()];
        int idx = 0;

        for(String name : map.keySet()) {
            arr[idx++] = name + " " + map.get(name);
        }

        Arrays.sort(arr);

        for(String name : arr) {
            System.out.println(name);
        }
    }
}
