package programmers.level2.skilltree;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String temp : skill_trees) {
            String str = temp;

            for(int i = 0; i < temp.length(); i++) {
                String tempStr = temp.charAt(i) + "";
                if(!skill.contains(tempStr)) {
                    str = str.replace(tempStr, "");
                }
            }

            if(skill.indexOf(str) == 0) {
                answer++;
            }
        }

        return answer;
    }
}