package leetCode.majorityElement;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int num : nums) {
            if(!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        int max = 0;
        int index = 0;

        for(Integer key : hashMap.keySet()) {
            if(max < hashMap.get(key)) {
                index = key;
                max = hashMap.get(key);
            }
        }

        return index;
    }
}
