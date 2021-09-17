package codility.frogJump;

public class Solution {
    public int solution(int X, int Y, int D) {
        if(Y <= X) {
            return 0;
        }

        if((Y - X) % D == 0) {
            return (Y - X) / D;
        }

        return (Y - X) / D + 1;
    }
}
