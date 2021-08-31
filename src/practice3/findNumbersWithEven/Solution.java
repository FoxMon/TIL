package practice3.findNumbersWithEven;

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(check(nums[i])) {
                count++;
            }
        }

        return count;
    }

    public static boolean check(int num) {
        int count = 0;

        while(num >= 1) {
            num /= 10;
            count++;
        }

        if(count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100000};
        Solution solution = new Solution();
        System.out.println(solution.findNumbers(nums));
    }
}
