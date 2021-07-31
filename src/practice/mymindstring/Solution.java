package practice.mymindstring;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<String> temp = new ArrayList<>();

        for(int i = 0; i < strings.length; i++) {
            temp.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(temp);

        for(int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i).substring(1);
        }

        return answer;
    }
}
