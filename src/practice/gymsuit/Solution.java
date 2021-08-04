package practice.gymsuit;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];

        for(int i : reserve) { // 있는데, 여벌도 있는 놈
            students[i - 1]++;
        }

        for(int i : lost) { // 도둑당한놈
            students[i - 1]--;
        }

        for(int i = 0; i < students.length; i++) {
            if(students[i] < 0) {
                if((i != students.length -1) && (students[i + 1] > 0)) { // 뒷 놈한테 빌리기
                    students[i]++;
                    students[i+1]--;
                } else if((i != 0) && (students[i - 1] > 0)) { // 앞 놈한테 빌리기
                    students[i]++;
                    students[i-1]--;
                }
            }
        }

        for(int i = 0; i < students.length; i++) {
            if(students[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }
}
