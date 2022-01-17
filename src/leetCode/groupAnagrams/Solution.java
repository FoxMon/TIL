package leetCode.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) { return new ArrayList<>(); }
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for(String temp : strs) {
            char[] ch = temp.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            hashMap.get(key).add(temp);
        }

        return new ArrayList<>(hashMap.values());
    }
}
