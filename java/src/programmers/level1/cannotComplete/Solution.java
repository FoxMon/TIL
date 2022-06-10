package programmers.level1.cannotComplete;

import java.util.HashMap;
import java.util.Set;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();

        for(String play : participant) {
            int count = 1;

            if(!player.containsKey(play)) {
                player.put(play, count);
            } else { // same name
                int already = player.get(play);
                player.put(play, already + count);
            }
        }

        for(String complete : completion) {
            if(player.get(complete) >  1) {
                int temp = player.get(complete);
                player.put(complete, temp - 1);
            } else {
                player.remove(complete);
            }
        }

        Set<String> result = player.keySet();

        for(String temp : result) {
            answer += temp;
        }

        return answer;
    }
}
