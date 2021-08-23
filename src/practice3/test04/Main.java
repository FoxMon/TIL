package practice3.test04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] cnt = new int[9];
        Scanner scanner = new Scanner(System.in);
        String str = "";
        String result = "";
        String temp = "";
        String[] temp2;
        int num;
        int index = 0;

        temp = scanner.nextLine();
        temp2 = temp.split(" ");

        for(int i = 0; i < temp2.length; i++) {
            str += temp2[i];
        }
//        str = scanner.nextLine();
        result = "";

        while(str.charAt(index) != '0') {
            num = str.charAt(index) - '0';
            cnt[num - 1]++;

            if ((str.charAt(index) != str.charAt(index + 1))) {
                result += cnt[num - 1] + "" + num;
                cnt[num - 1] = 0;
            }
            index++;
        }

        for(int i = 0; i < result.length(); i++) {
            System.out.print(result.charAt(i) + " ");
        }
    }
}
