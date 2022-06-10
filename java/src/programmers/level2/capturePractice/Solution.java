package programmers.level2.capturePractice;

import java.util.HashMap;

public class Solution {
    public static HashMap<Character, Integer> hashMap;
    public static String[] strings;
    public static boolean[] checked;
    public static int[] character;
    public static int answer;

    public int solution(int n, String[] data) {
        strings = data;
        checked = new boolean[8];
        character = new int[8];
        hashMap = new HashMap<>();
        answer = 0;
        hashMap.put('A', 0);
        hashMap.put('C', 1);
        hashMap.put('F', 2);
        hashMap.put('J', 3);
        hashMap.put('M', 4);
        hashMap.put('N', 5);
        hashMap.put('R', 6);
        hashMap.put('T', 7);
        dfs(0);

        return answer;
    }

    public static void dfs(int index) {
        if(index == 8) {
            if(check()) {
                answer++;
            }
        } else {
            for(int i = 0; i < 8; i++) {
                if(!checked[i]) {
                    checked[i] = true;
                    character[index] = i;
                    dfs(index + 1);
                    checked[i] = false;
                }
            }
        }
    }

    public static boolean check() {
        int first;
        int second;
        int result;
        char option;

        for(String str : strings) {
            first = character[hashMap.get(str.charAt(0))];
            second = character[hashMap.get(str.charAt(2))];
            option = str.charAt(3);
            result = str.charAt(4) - '0' + 1;

            if(option == '=') {
                if(Math.abs(first - second) != result) {
                    return false;
                }
            } else if(option == '>') {
                if(Math.abs(first - second) <= result) {
                    return false;
                }
            } else {
                if (Math.abs(first - second) >= result) {
                    return false;
                }
            }
        }

        return true;
    }
}
