package practice.strangecharacter;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ", -1);
        String temp = "";

        for(int i = 0; i < str.length; i++) {
            for(int j = 0; j < str[i].length(); j++) {
                if(j % 2 == 0) {
                    temp += Character.toUpperCase(str[i].charAt(j)) + "";
                } else {
                    temp += Character.toLowerCase(str[i].charAt(j)) + "";
                }
            }

            temp += " ";
        }
        answer = temp.substring(0, temp.length() - 1);
        return answer;
    }
}
