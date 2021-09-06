package practice2.copy01;

public class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            if(getCount(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public static int getCount(int number) {
        int count = 0;

        for(int i = 1; i <= number; i++) {
            if(number % i == 0) {
                count++;
            }
        }

        return count;
    }
}
