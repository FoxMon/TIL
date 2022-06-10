package programmers.level2.hide;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> combi = new HashMap<>();
        int answer = 1;
        int count = 1;

        for(int i = 0; i < clothes.length; i++) {
            String temp = clothes[i][1];
            if(!combi.containsKey(temp)) {
                combi.put(temp, count);
            } else {
                int already = combi.get(temp);
                combi.put(temp, already + count);
            }
        }

        Set<String> keys = combi.keySet();
        for(String key : keys) {
            answer *= combi.get(key) + 1;
        }

        return answer - 1;
    }
}
