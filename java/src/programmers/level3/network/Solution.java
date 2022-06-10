package programmers.level3.network;

public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                answer++;
                network(i, computers, check);
            }
        }
        return answer;
    }

    public void network(int start, int[][] computers, boolean[] check) {
        check[start] = true;

        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !check[i]) {
                network(i, computers, check);
            }
        }
    }
}
