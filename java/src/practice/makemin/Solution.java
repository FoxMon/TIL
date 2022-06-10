package practice.makemin;

import java.util.Arrays;

public class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        B = reverse(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }

    public int[] reverse(int[] a) {
        Arrays.sort(a);

        for(int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }

        return a;
    }
}
