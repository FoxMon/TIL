package practice.nextbetterbig;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String b_num = Integer.toBinaryString(n);
        int firstCnt = count(b_num);
        int next = n + 1;

        while(true) {
            String b_next = Integer.toBinaryString(next);
            int secountCnt = count(b_next);

            if(firstCnt == secountCnt) {
                answer = next;
                break;
            }
            next++;
        }

        return answer;
    }

    public int count(String b_num) {
        int cnt = 0;
        char[] temp = b_num.toCharArray();

        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == '1') {
                cnt++;
            }
        }

        return cnt;
    }
}
