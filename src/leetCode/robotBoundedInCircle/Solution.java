package leetCode.robotBoundedInCircle;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] direction = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 }
        };
        int currentDir = 0;
        int x = 0;
        int y = 0;

        for(char ch : instructions.toCharArray()) {
            if(ch == 'R') {
                currentDir = (currentDir + 1) % 4;
            } else if(ch == 'L') {
                currentDir = (currentDir + 3) % 4;
            } else {
                x += direction[currentDir][0];
                y += direction[currentDir][1];
            }
        }

        return x == 0 && y == 0 || currentDir > 0;
    }
}
