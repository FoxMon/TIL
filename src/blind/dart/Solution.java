package blind.dart;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int score_index = -1;
        int[] scores = new int[3];

        for(int i = 0; i < dartResult.length(); i++) {
            if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') { // score
                if(dartResult.charAt(i) == 'D') {
                    scores[score_index] *= scores[score_index];
                } else if(dartResult.charAt(i) == 'T') {
                    scores[score_index] *= scores[score_index] * scores[score_index];
                }
            } else if(dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#') { // bonus
                if(dartResult.charAt(i) == '*') {
                    if(score_index >= 1) {
                        scores[score_index - 1] *= 2;
                    }

                    scores[score_index] *= 2;
                } else {
                    scores[score_index] *= -1;
                }
            } else { // number
                if(dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    i++;
                    score_index++;
                    scores[score_index] = 10;
                } else {
                    score_index++;
                    scores[score_index] = dartResult.charAt(i) - '0';
                }
            }
        }

        for(int number : scores) {
            answer += number;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1D2S#10S"));
    }
}
