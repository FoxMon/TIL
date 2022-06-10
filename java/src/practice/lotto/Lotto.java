package practice.lotto;

class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = {};
        int zero = 0;
        int match = 0;

        for (int i = 0; i < lottos.length; i++) {

            if (lottos[i] == 0) {
                zero++;
            }

            for (int j = 0; j < lottos.length; j++) {

                if (lottos[i] == win_nums[j]) {
                    match++;
                    break;
                }
            }
        }

        int top = rank(match + zero);
        int lower = rank(match);

        answer = new int[]{top, lower};

        return answer;
    }

    public static int rank(int count) {

        int result = 0;

        switch(count) {
            case 1:
                result = 6;
                break;

            case 2:
                result = 5;
                break;

            case 3:
                result = 4;
                break;

            case 4:
                result = 3;
                break;

            case 5:
                result = 2;
                break;

            case 6:
                result = 1;
                break;

            default :
                result = 6;
                break;
        }

        return result;
    }
}

public class Lotto {

    public static void main(String[] args) {

        Solution solution = new Solution();

        for(int i = 0; i < 2; i++) {
            System.out.print(solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})[i]);
        }
        System.out.println();

        for(int i = 0; i < 2; i++) {
            System.out.print(solution.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})[i]);
        }
        System.out.println();

        for(int i = 0; i < 2; i++) {
            System.out.print(solution.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})[i]);
        }
        System.out.println();
    }
}
