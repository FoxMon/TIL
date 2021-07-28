package practice.nlcm;

public class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcm(num1, num2);
    }

    public static int gcm(int num1, int num2) {
        while(num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }

        return num1;
    }
}
