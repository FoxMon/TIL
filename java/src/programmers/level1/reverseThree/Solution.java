package programmers.level1.reverseThree;

import java.util.ArrayList;

public class Solution {
    public int solution(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int answer = 0;

        while(true) { // 0021
            if(n < 3) {
                numbers.add(n);
                break;
            }

            numbers.add(n % 3);
            n /= 3;
        }

        int multiple = 1;
        for(int i = 0; i < numbers.size(); i++) {
            answer += (numbers.get(numbers.size() - 1 - i) * multiple);
            multiple *= 3;
        }

        return answer;
    }
}
