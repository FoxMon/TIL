package practice.fibo;

public class Solution {
    public int solution(int n) {
        int n1 = 0;
        int n2 = 1;

        for(int i =0; i < n; i++) {
            int next = (n1 + n2) % 1234567;
            n1 = n2 % 1234567;
            n2 = next % 1234567;
        }

        return n1;
    }
}
