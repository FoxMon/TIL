package practice.makeprimarynumber;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> sums = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(i + 2 > nums.length) {
                break;
            }
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    sums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for (Integer sum : sums) {
            if (isPrimaryNumber(sum)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrimaryNumber(int number) {
        int cnt = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                cnt++;
            }
        }

        if(cnt == 2) {
            return true;
        }

        return false;
    }
}
