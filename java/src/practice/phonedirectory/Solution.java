package practice.phonedirectory;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashMap<String, Integer> directory = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++) {
            directory.put(phone_book[i], i);
        }

        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(directory.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
