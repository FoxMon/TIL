package practice3.sequenceArray;

import java.util.Arrays;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        String temp = "";

        for(int i = 0; i < nums.length; i++) {
            temp += Integer.toString(nums[i]);
        }

        String[] find = temp.split("0");
        int[] counts = new int[find.length];

        for(int i = 0; i < find.length; i++) {
            counts[i] = find[i].length();
        }

        if(counts.length == 0) {
            return 0;
        }

        Arrays.sort(counts);

        return counts[counts.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {0};
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }
}
