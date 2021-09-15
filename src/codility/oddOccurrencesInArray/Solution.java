package codility.oddOccurrencesInArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        Set<Integer> map = new HashSet<>();

        for(int i = 0; i < A.length; i++) {
            if (!map.contains(A[i])) {
                map.add(A[i]);
            } else {
                map.remove(A[i]);
            }
        }

        int answer = map.iterator().next();
        return answer;
    }
}
