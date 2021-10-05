package everyday.order;

public class Solution {
    public String solution(int n, int[] p, int[] c) {
        int price = 100, stock = 0;
        double result = 0;
        for (int i = 0; i < n && price >= 25; ++i) {
            stock += p[i];
            if (stock >= c[i]) {
                result += c[i] * price;
                stock -= c[i];
                price = 100;
            } else
                price /= 2;
        }

        return String.format("%.2f", (double)result / n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][] {{5, 4, 7, 2, 0, 6}, {4, 6, 4, 9, 2, 3}};
        int[][] b = new int[][] {{6, 2, 1, 0, 2, 4, 3}, {3, 6, 6, 2, 3, 7, 6}};
        System.out.println(solution.solution(a[0].length, a[0], a[1]));
        System.out.println(solution.solution(b[0].length, b[0], b[1]));
    }
}
