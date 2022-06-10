package practice.mockexam;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int first1 = check(first, answers);
        int second1 = check(second, answers);
        int third1 = check(third, answers);
        int max = Math.max(Math.max(first1, second1), third1);
        ArrayList<Integer> maxPerson = new ArrayList<>();

        if(first1 == max) {
            maxPerson.add(1);
        }

        if(second1 == max) {
            maxPerson.add(2);
        }

        if(third1 == max) {
            maxPerson.add(3);
        }

        answer = new int[maxPerson.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = maxPerson.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public int check(int[] person, int[] answer) {
        int cnt = 0;

        for(int i = 0; i < answer.length; i++) {
            if(person[i % person.length] == answer[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}
