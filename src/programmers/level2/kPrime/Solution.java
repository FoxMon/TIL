package programmers.level2.kPrime;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int i, j;
        String number = change(n, k);

        for(i = 0; i < number.length(); i = j) {
            for(j = i + 1; j < number.length() && number.charAt(j) != '0'; j++);
            if(checkPrime(Long.parseLong(number.substring(i,j)))) { answer++; }
        }

        return answer;
    }

    private boolean checkPrime(long target) {
        if(target <= 1) { return false; }
        if(target == 2) { return true; }
        for(int i = 2; i <= Math.sqrt(target); i++) {
            if(target % i == 0) {
                return false;
            }
        }

        return true;
    }

    private String change(int target, int k) {
        String result = "";
        while(target > 0) {
            result = target % k + result;
            target /= k;
        }

        return result;
    }
}
