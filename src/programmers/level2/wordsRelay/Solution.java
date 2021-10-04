package programmers.level2.wordsRelay;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn = 0;
        int myTurn = 1;
        ArrayList<String> relay = new ArrayList<>();
        String current = words[0];
        turn++;
        relay.add(current);

        for(int i = 1; i < words.length; i++) {
            turn %= n;

            if(turn == 0) {
                myTurn++;
            }

            String next = words[i];

            if(!relay.contains(next) && next.charAt(0) == current.charAt(current.length() - 1)) {
                relay.add(next);
                current = next;
                turn++;
            } else {
                answer[0] = turn + 1;
                answer[1] = myTurn;
                return answer;
            }
        }

        return answer;
    }
}
