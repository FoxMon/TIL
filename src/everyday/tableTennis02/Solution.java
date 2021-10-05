package everyday.tableTennis02;

public class Solution {
    public String solution(int n, int[] p, int[] c) {
        int price = 100;
        int result = 0;
        int stock = 0;

        for(int i = 0; i < n; i++) {
            stock += p[i];

            if(stock >= c[i]) {
                result += (price * c[i]);
                stock -= c[i];
                price = 100;
            } else {
                price /= 2;
            }
        }

        return String.format("%.2f", (double)result / n);
    }
}
