package leetCode.containerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int max = 0;

        while(first != last) {
            max = Math.max((last - first) * Math.min(height[first], height[last]), max);
            if(height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }
        return max;
    }
}
