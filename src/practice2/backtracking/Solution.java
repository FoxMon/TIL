package practice2.backtracking;

public class Solution {
    public static boolean[] visited = new boolean[9];
    public static int n, m;
    public static int[] numbers = new int[9];

    public void backTracking(int count) {
        if(count == m) {
            for(int i  = 0; i < m; i++) {
                System.out.print(numbers[i] + " ");
            }

            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            numbers[count] = i;
            backTracking(count+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        n = 4; m = 2;
        solution.backTracking(0);
    }
}
