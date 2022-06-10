package leetCode.twoSum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if(num1 + num2 == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }

        return answer;
    }
}
