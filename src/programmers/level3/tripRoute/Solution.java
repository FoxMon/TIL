package programmers.level3.tripRoute;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static boolean[] visited;
    public static ArrayList<String> route;

    public String[] solution(String[][] tickets) {
        String[] answer;
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(route);
        answer = route.get(0).split(" ");

        return answer;
    }

    public void dfs(String[][] tickets, String current, String target, int level) {
        if(level >= tickets.length) {
            route.add(target);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], target + " " + tickets[i][1], level + 1);
                visited[i] = false;
            }
        }
    }
}
