package programmers.level1.evaluation;

public class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int total = scores.length;

        for(int i = 0; i < total; i++) {
            int max = 0;
            int min = 101;
            int result = 0;
            int divide = total;
            int myScore = scores[i][i];

            for(int j = 0; j < total; j++) {
                result += scores[j][i];

                if(i != j) {
                    if(max < scores[j][i]) {
                        max = scores[j][i];
                    }

                    if(min > scores[j][i]) {
                        min = scores[j][i];
                    }
                }
            }

            if(myScore < min || myScore > max) {
                divide--;
                result -= myScore;
            }

            result /= divide;

            if(result >= 90) {
                answer += "A";
            } else if(result >= 80 && result < 90) {
                answer += "B";
            } else if(result >= 70 && result < 80) {
                answer += "C";
            } else if(result >= 50 && result < 70) {
                answer += "D";
            } else {
                answer += "F";
            }
        }

        return answer;
    }
}
