package practice2.skill021;

public class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int temp = arr[0];

        for(int i = 0; i < arr.length; i++) {
            temp = lcm(arr[i], temp);
        }

        answer = temp;

        return answer;
    }

    public static int gcb(int num1, int num2) {
        while(num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1;
    }

    public static int lcm(int num1, int num2) {
        return num1 * num2 / gcb(num1, num2);
    }
}
