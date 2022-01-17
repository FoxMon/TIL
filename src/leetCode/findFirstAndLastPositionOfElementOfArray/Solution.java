package leetCode.findFirstAndLastPositionOfElementOfArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = getFirst(nums, target);
        answer[1] = getLast(nums, target);
        return answer;
    }

    private int getFirst(int[] nums, int target) {
        int index = -1;
        int first = 0;
        int last = nums.length - 1;
        while(first <= last) {
            int mid = (first + last) / 2;
            if(nums[mid] >= target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }

            if(target == nums[mid]) { index = mid; }
        }

        return index;
    }

    private int getLast(int[] nums, int target) {
        int index = -1;
        int first = 0;
        int last = nums.length - 1;
        while(first <= last) {
            int mid = (first + last) / 2;
            if(nums[mid] <= target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }

            if(target == nums[mid]) { index = mid; }
        }
        return index;
    }
}
