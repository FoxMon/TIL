package leetCode.findTheDuplicateNumber;

import java.util.HashMap;

public class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int answer = 0;
        for(int num : nums) {
            if(hashMap.containsKey(num)) {
                answer = num;
                return answer;
            }
            hashMap.put(num, true);
        }
        return answer;
    }
}
