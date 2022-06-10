package programmers.level3.seller;

import java.util.HashMap;

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, String> parents = new HashMap<>(); // me, parent
        HashMap<String, Integer> member = new HashMap<>(); // me, index

        for(int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            member.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int benefit = 100 * amount[i];

            while(!current.equals("-")) {
                int value = benefit / 10; // parent
                int now = benefit - value;
                answer[member.get(current)] += now;
                current = parents.get(current);
                benefit /= 10;

                if(benefit < 1) {
                    break;
                }
            }
        }

        return answer;
    }
}
