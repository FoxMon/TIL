package lv01.ponketmon;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int[] nums) {


        if(getSizeOfSet(nums) < nums.length / 2) {

            return getSizeOfSet(nums);
        }

        return nums.length / 2;
    }

    Integer getSizeOfSet(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i : nums) {

            set.add(i);
        }

        return set.size();
    }
}

public class PonKetMon {

    public static void main(String[] args) {

        Solution solution = new Solution();
    }
}
