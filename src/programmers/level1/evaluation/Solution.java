package programmers.level1.evaluation;

public class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        for(int i = 0; i < scores.length; i++) {
            int myScore = scores[i][i];
            int total = scores[i].length;
            int result = 0;
            int max = 0;
            int min = 101;

            for(int j = 0; j < scores[i].length; j++) {
                if(i != j) {
                    if(min > scores[j][i]) {
                        min = scores[j][i];
                    }
                    if(max < scores[j][i]) {
                        max = scores[j][i];
                    }
                }

                result += scores[j][i];
            }

            if(myScore < min || myScore > max) {
                total--;
                result -= myScore;
            }
            result /= total;
            if(result >= 90) {
                answer += "A";
            } else if(result >= 80) {
                answer += "B";
            } else if(result >= 70) {
                answer += "C";
            } else if(result >= 50) {
                answer += "D";
            } else {
                answer += "F";
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.println(solution.solution(scores));
    }
}
