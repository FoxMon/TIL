package practice.threenumber;

import java.util.ArrayList;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList<>();

        while(true) {
            if(n < 3) {
                numbers.add(n);
                break;
            }

            numbers.add(n % 3);
            n /= 3;
        }

        for(int i = 0; i < numbers.size(); i++) {
            answer += (Math.pow(3, numbers.size() - 1 - i) * numbers.get(i));
        }

        return answer;
    }
}
