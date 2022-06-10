package programmers.level2.openChat;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> results = new ArrayList<>();
        HashMap<String, String> users = new HashMap<>();

        for(int i = 0; i < record.length; i++) {
            String[] records = record[i].split(" ");

            if(records[0].equals("Enter")) {
                results.add(records[1] + "님이 들어왔습니다.");
                users.put(records[1], records[2]);
            } else if(records[0].equals("Change")) {
                users.put(records[1], records[2]);
            } else {
                results.add(records[1] + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[results.size()];

        for(int i = 0; i < results.size(); i++) {
            int index = results.get(i).indexOf("님");
            String id = results.get(i).substring(0, index);
            String[] temp = results.get(i).split(" ");
            answer[i] = users.get(id) + "님이 " + temp[1];
        }

        return answer;
    }
}
