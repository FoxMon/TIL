package practice.failure;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<User> users = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            int now = 0;
            int clear = 0;

            for(int stage : stages) {
                if(i <= stage) {
                    clear++;
                }

                if(i == stage) {
                    now++;
                }
            }

            if(clear == 0) {
                users.add(new User(i, 0));
            } else {
                users.add(new User(i, (double)now / clear));
            }
        }

        users.sort(User::compareTo);

        for(int i = 0; i < users.size(); i++) {
            answer[i] = users.get(i).getIndex();
        }

        return answer;
    }

    class User implements Comparable<User> {
        private int index;
        private double failure;

        public User(int index, double failure) {
            this.index = index;
            this.failure = failure;
        }

        @Override
        public int compareTo(User user) {
            if(this.failure == user.failure) {
                return this.index < user.index ? -1 : 1;
            } else {
                return this.failure > user.failure ? -1 : 1;
            }
        }

        public int getIndex() { return this.index; }
        public double getFailure() { return this.failure; }
    }
}
