package programmers.level2.primeCheck;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean[] visited;
    public static char[] result;
    public static Set<Integer> prime = new HashSet<>();

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        result = new char[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++) {
            find(numbers, i, 0);
        }

        return prime.size();
    }

    public static void find(String numbers, int len, int level) {
        if(level == len) {
            int number = change(result, len);
            if(findPrimeNumber(number)) {
                prime.add(number);
            }
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[level] = numbers.charAt(i);
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

    public static boolean findPrimeNumber(int num) { // 여기서 시간초과 나면 안됨
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
