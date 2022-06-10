package practice.betweennumsum;

public class Solution {
    public long solution(long a, long b) {
        long answer = 0;
        long first;
        long last;

        if(a == b) {
            return a;
        } else if(a < b) {
            first = a;
            last = b;
        } else {
            first = b;
            last = a;
        }

        while(first <= last) {
            answer += first;
            first++;
        }

        return answer;
    }
}
