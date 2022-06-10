package practice2.secretmap;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            map1[i] = Integer.toBinaryString(arr1[i]);
            map2[i] = Integer.toBinaryString(arr2[i]);
        }

        for(int i = 0; i < n; i++) {
            while(map1[i].length() != n) {
                map1[i] = "0" + map1[i];
            }

            while(map2[i].length() != n) {
                map2[i] = "0" + map2[i];
            }
        }

        for(int i = 0; i < n; i++) {
            String temp = "";
            for(int j = n - 1; j >= 0; j--) {
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1') {
                    temp = temp + "#";
                } else {
                    temp = temp + " ";
                }
            }
            str[i] = temp;
        }

        for(int i = 0; i < str.length; i++) {
            String temp = "";
            for(int j = str.length-1; j >= 0; j--) {
                temp += str[i].charAt(j);
            }

            answer[i] = temp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] test = solution.solution(6, arr1, arr2);

        for (String s : test) {
            System.out.println(s + "  length : " + s.length());
        }
    }
}
