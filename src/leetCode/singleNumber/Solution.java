package leetCode.singleNumber;

import java.util.ArrayList;

public class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> results = new ArrayList<>();
        for(int num : nums) {
            if(!results.contains(num)) {
                results.add(num);
            } else {
                Integer temp = num;
                results.remove(temp);
            }
        }

        return results.get(0);
    }
}
