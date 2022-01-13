package programmers.level2.leagueTable;

public class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int first = 0;
        int last = 0;

        if(a > b) {
            first = b;
            last = a;
        } else {
            first = a;
            last = b;
        }

        while(true) {
            if(first % 2 != 0 && last - first == 1) {
                break;
            }

            first = (first + 1) / 2;
            last = (last + 1) / 2;
            answer++;
        }

        return answer + 1;
    }
}
