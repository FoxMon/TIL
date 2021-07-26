package practice.failedplayer;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            if(player.containsKey(participant[i])) {
                player.put(participant[i], player.get(participant[i]) + 1);
            } else {
                player.put(participant[i], 1);
            }
        }
        for(int i = 0; i < completion.length; i++) {
            if(player.get(completion[i]) > 1) {
                player.put(completion[i], player.get(completion[i]) - 1);
            } else {
                player.remove(completion[i]);
            }
        }

        answer = player.keySet().toString();
        answer = answer.substring(1, answer.length() - 1);
        return answer;
    }
}
