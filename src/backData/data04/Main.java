package backData.data04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> results = new ArrayList<>();
        int total = 0;

        while(scanner.hasNextLine()) {
            String tree = scanner.nextLine();
            total++;

            if(!hashMap.containsKey(tree)) {
                hashMap.put(tree, 1.0);
            } else {
                double count = hashMap.get(tree);
                count++;
                hashMap.put(tree, count);
            }
        }

        Set<String> set = hashMap.keySet();

        for(String key : set) {
            double count = hashMap.get(key);
            results.add(key + " " + String.format("%.4f", (count / total) * 100) + "\n");
        }

        Collections.sort(results);

        for(String result : results) {
            stringBuilder.append(result);
        }

        System.out.println(stringBuilder.toString());
    }
}
