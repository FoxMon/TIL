package practice3.containDuplicate;

import java.util.Arrays;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i+1 < nums.length) {
                if(nums[i] == nums[i + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
