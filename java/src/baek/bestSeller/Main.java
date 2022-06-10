package baek.bestSeller;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] books = new String[count];
        HashMap<String, Integer> maps = new HashMap<>();

        for(int i = 0; i < books.length; i++) {
            books[i] = scanner.next();
            if(maps.containsKey(books[i])) {
                maps.replace(books[i], maps.get(books[i]) + 1);
            } else {
                maps.put(books[i], 1);
            }
        }

        int max = 0;

        for(String book : maps.keySet()) {
            max = Math.max(max, maps.get(book));
        }

        ArrayList<String> list = new ArrayList<>(maps.keySet());
        Collections.sort(list);

        for(String book : list) {
            if(max == maps.get(book)) {
                System.out.println(book);
                break;
            }
        }
    }
}
