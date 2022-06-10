package programmers.level2.menuRenew;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static HashMap<String, Integer> hashMap;
    public static int max;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        for(int i = 0; i < course.length; i++) {
            hashMap = new HashMap<>();
            max = 0;

            for(int j = 0; j < orders.length; j++) {
                makeMenu(orders[j], "", course[i], 0, 0);
            }

            for(String result : hashMap.keySet()) {
                if(hashMap.get(result) == max && max > 1) {
                    queue.offer(result);
                }
            }
        }

        String[] answer = new String[queue.size()];
        int index = 0;
        while(!queue.isEmpty()) {
            answer[index++] = queue.poll();
        }
        return answer;
    }

    public static void makeMenu(String order, String result, int course, int index, int level) {
        if(level == course) {
            char[] temp = result.toCharArray();
            Arrays.sort(temp);
            String str = "";

            for(char ch : temp) {
                str += ch;
            }

            if(!hashMap.containsKey(str)) {
                hashMap.put(str, 1);
            } else {
                hashMap.put(str, hashMap.get(str) + 1);
            }

            max = Math.max(max, hashMap.get(str));
            return;
        }

        for(int i = index; i < order.length(); i++) {
            char current = order.charAt(i);
            makeMenu(order, result + current, course, i + 1, level + 1);
        }
    }
}
