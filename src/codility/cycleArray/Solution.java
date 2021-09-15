package codility.cycleArray;

public class Solution {
    public int[] solution(int[] A, int K) {
        int[] numbers = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            numbers[(i + K) % A.length] = A[i];
        }

        return numbers;
    }
}
