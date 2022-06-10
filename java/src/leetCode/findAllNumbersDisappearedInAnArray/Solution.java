package leetCode.findAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        boolean[] numbers = new boolean[nums.length + 1];
        List<Integer> results = new ArrayList<>();

        for(int num : nums) {
            numbers[num] = true;
        }

        for(int i = 1; i < numbers.length; i++) {
            if(!numbers[i]) {
                results.add(i);
            }
        }

        return results;
    }
}
