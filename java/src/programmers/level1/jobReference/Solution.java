package programmers.level1.jobReference;

public class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[] jobs = new String[table.length];

        for(int i = 0; i < table.length; i++) {
            jobs[i] = table[i];
        }

        int max = 0;

        for(String job : jobs) {
            String[] temp = job.split(" ");
            String category = temp[0];
            int score = 5;
            int result = 0;

            for(int i = 1; i <= 5; i++) {
                for(int j = 0; j < languages.length; j++) {
                    if(temp[i].equals(languages[j])) {
                        result += preference[j] * score;
                        break;
                    }
                }
                if(max < result) {
                    max = result;
                    answer = category;
                } else if(max == result) {
                    if(answer.compareTo(category) > 0) {
                        answer = category;
                    }
                }
                score--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] table = {
                "SI JAVA JAVASCRIPT SQL PYTHON C#",
                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA"
        };
        String[] language = {
                "PYTHON", "C++", "SQL"
        };
        int[] preferences = {
                7, 5, 5
        };

        System.out.println(solution.solution(table, language, preferences));
    }
}
