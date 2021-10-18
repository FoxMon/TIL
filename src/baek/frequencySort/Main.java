package baek.frequencySort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        for(int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            if(!hashMap.containsKey(number)) {
                hashMap.put(number, 1);
            } else {
                int value = hashMap.get(number);
                value++;
                hashMap.replace(number, value);
            }
        }

        ArrayList<Integer> values = new ArrayList<>(hashMap.keySet());
        Collections.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer value1, Integer value2) {
                return Integer.compare(hashMap.get(value2), hashMap.get(value1));
            }
        });

        for(int value : values) {
            for(int i = 0; i < hashMap.get(value); i++) {
                System.out.print(value + " ");
            }
        }
    }
}
