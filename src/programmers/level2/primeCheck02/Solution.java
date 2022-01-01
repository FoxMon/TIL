package programmers.level2.primeCheck02;

import java.util.ArrayList;

public class Solution {
    public static boolean[] visited;
    public static char[] results;
    public static ArrayList<Integer> list;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        results = new char[numbers.length()];
        list = new ArrayList<>();

        for(int i = 1; i <= numbers.length(); i++) {
            find(numbers, i, 0);
        }

        return list.size();
    }

    public static void find(String numbers, int len, int level) {
        if(level == len) {
            int target = change(results, len);
            if(findPrime(target)) {
                if(!list.contains(target)) {
                    list.add(target);
                }
            }
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                results[level] = numbers.charAt(i);
                find(numbers, len, level + 1);
                visited[i] = false;
            }
        }
    }

    public static int change(char[] arr, int len) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < len; i++) {
            stringBuilder.append(arr[i]);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static boolean findPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }

        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
