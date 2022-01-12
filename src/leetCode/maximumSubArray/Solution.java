package leetCode.maximumSubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(max < num) {
                max = num;
            }

            if(sum + num < 0) {
                sum = 0;
            } else {
                sum += num;
                if(maxSum < sum) {
                    maxSum = sum;
                }
            }
        }

        if(maxSum == 0) {
            return max;
        }

        return maxSum;
    }
}
