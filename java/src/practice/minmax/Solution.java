package practice.minmax;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int[] nums = new int[temp.length];

        for(int i = 0; i < temp.length; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        Integer min = nums[0];
        Integer max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        answer = min.toString();
        answer = answer + " " + max.toString();

        return answer;
    }
}
