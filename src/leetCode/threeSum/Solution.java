package leetCode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // -4, -1, -1, 0, 1, 2
        Arrays.sort(nums);                            // 0, 1, 2, 3, 4, 5
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int target = 0 - nums[i] - nums[j];
                if(hashMap.containsKey(target) && hashMap.get(target) > j) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                    j = hashMap.get(nums[j]);
                }
                i = hashMap.get(nums[i]);
            }
        }

        return result;
    }
}
