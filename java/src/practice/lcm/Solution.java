package practice.lcm;

public class Solution {
    public int solution(int a, int b) {
        return (a*b) / gcm(a, b);
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
