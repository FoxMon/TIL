package leetCode.counitngBits;

public class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            String number = Integer.toBinaryString(i);
            int count = 0;
            for(int j = 0; j < number.length(); j++) {
                if(number.charAt(j) == '1') {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
