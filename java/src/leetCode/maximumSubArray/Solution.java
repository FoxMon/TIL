package leetCode.maximumSubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int answer = 0;

        for(int num : nums) {
            if(max < num) {
                max = num;
            }

            if(sum + num < 0) {
                sum = 0;
            } else {
                sum += num;
                answer = Math.max(answer, sum);
            }
        }

        if(answer == 0) {
            return max;
        }
        return answer;
    }
}
