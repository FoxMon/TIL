package practice3.lengthOfLongestSubString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] characters = s.toCharArray();
        int index = 0;
        int count = 0;
        int start = 0;
        int max = 0;

        while(index < characters.length) {
            if(!set.contains(characters[index])) {
                set.add(characters[index++]);
                count++;
            } else {
                set.clear();
                index = start++;
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count);
    }
}
