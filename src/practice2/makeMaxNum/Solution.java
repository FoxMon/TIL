package practice2.makeMaxNum;

public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        int index = 0;
        int length = number.length() - 1;

        for(int i = 0; i < k; i++) {
            index = length;

            for(int j = 0; j < length; j++){
                if(answer.charAt(j) < answer.charAt(j + 1)) {
                    index = j;
                    break;
                }
            }

            answer.deleteCharAt(index);
        }

        return answer.toString();
    }
}
