package practice.keypad;

public class Solution {

    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();
        
        int left=10, right=12;
        int left_distance, right_distance;
        
        for(int number : numbers) {
            left_distance = 0;
            right_distance = 0;

            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left = number;
            } else if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right = number;
            } else {
                if(number==0) {
                    number += 11;
                }

                left_distance = (Math.abs(number-left))/3 + (Math.abs(number-left))%3;
                right_distance = (Math.abs(right-number))/3 + (Math.abs(right-number))%3;

                if(left_distance == right_distance) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = number;
                    }else {
                        sb.append("L");
                        left = number;
                    }
                }else if(left_distance > right_distance) {
                    sb.append("R");
                    right = number;
                }else {
                    sb.append("L");
                    left = number;
                }
            }
        }

        return sb.toString();
    }
}