package programmers.level3.fillTiles;

public class Solution {
    public int solution(int n) {
        int[] tiles = new int[n + 1];

        tiles[1] = 1;
        tiles[2] = 2;

        if(n <= 2) {
            return n;
        }

        for(int i = 3; i <= n; i++) {
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 1000000007;
        }

        int answer = tiles[n];
        return answer;
    }
}
