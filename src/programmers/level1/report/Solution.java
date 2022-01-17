package programmers.level1.report;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        HashMap<String, Integer> mail = new HashMap<>();
        int[] answer = new int[id_list.length];

        for(String id : id_list) {
            hashMap.put(id, new HashSet<>());
            mail.put(id, 0);
        }

        for(String user : report) {
            String[] users = user.split(" ");
            hashMap.get(users[1]).add(users[0]);
        }

        for(String key : hashMap.keySet()) {
            HashSet<String> reporters = hashMap.get(key);
            if(reporters.size() >= k) {
                for(String reporter : reporters) {
                    int mails = mail.get(reporter);
                    mail.put(reporter, mails + 1);
                }
            }
        }

        for(int i = 0; i < answer.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }

        return answer;
    }
}
