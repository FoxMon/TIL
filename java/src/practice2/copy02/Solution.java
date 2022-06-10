package practice2.copy02;

public class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcm(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    public int gcm(int n, int m) {
        while(m != 0) {
            int a = n % m;
            n = m;
            m = a;
        }

        return n;
    }

    public int lcm(int n, int m) {
        return (n * m) / gcm(n, m);
    }
}
