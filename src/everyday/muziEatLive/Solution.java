package everyday.muziEatLive;

// 못 풀었음 다시 도전하자
public class Solution {
    public long solution(int[] food_times, long k) {
        long answer = -1;
        int rotate = 0;
        long times = 0;

        for(int i = 0; i < food_times.length; i++) {
            times += food_times[i];
        }

        if(times <= k) {
            return -1;
        }

        while(times-- > -1) {
            if(times == k) {
                answer = rotate + 1;
                break;
            }

            if(food_times[rotate] == 0) {
                continue;
            }

            food_times[rotate]--;
            rotate++;
            rotate = rotate % food_times.length;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] food = { 3, 1, 2 };
        int k = 5;

        Solution solution = new Solution();
        System.out.println(solution.solution(food, k));
    }
}
