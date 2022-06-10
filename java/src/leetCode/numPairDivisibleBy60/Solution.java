package leetCode.numPairDivisibleBy60;

import java.util.HashMap;

public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;

        for(int number : time) {
            count += hashMap.getOrDefault((60 - number % 60) % 60, 0);
            hashMap.put(number % 60, hashMap.getOrDefault(number % 60, 0) + 1);
        }

        return count;
    }
}
