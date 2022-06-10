package leetCode.combination;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();

        for(int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);
            find(candidates, i, 1, target - candidates[i], temp);
        }

        return results;
    }

    private void find(int[] candidates, int index, int size, int target, List<Integer> temp) {
        if(target == 0) {
            results.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target) {
                temp.add(candidates[i]);
                find(candidates, i, size + 1, target - candidates[i], temp);
                temp.remove(size);
            }
        }
    }
}
