package programmers.level3.stepTooth;

import java.util.HashMap;

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> member = new HashMap<>();
        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
            member.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int money = 100 * amount[i];

            while(!current.equals("-")) {
                int parentMoney = money / 10;
                int nowMoney = money - parentMoney;
                answer[member.get(current)] += nowMoney;
                current = parents.get(current);
                money /= 10;

                if(money < 1) {
                    break;
                }
            }
        }

        return answer;
    }
}
