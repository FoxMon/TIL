package baekString.string07;

import java.util.Arrays;
import java.util.Scanner;

public class Main { // 3107
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.next();
        String[] ips= new String[8];
        Arrays.fill(ips, "0000");

        if(temp.contains("::")) {
            String[] divide = {"", ""};
            int idx = 0;
            for(String ipTemp : temp.split("::")) {
                divide[idx++] = ipTemp;
            }
            String[] left = divide[0].split(":");
            String[] right = divide[1].split(":");
            for(int i = 0; i < left.length; i++) {
                ips[i] = makeIP(left[i]);
            }
            int index = right.length - 1;
            for(int i = 7; i > 7 - right.length; i--) {
                ips[i] = makeIP(right[index--]);
            }
        } else {
            String[] ip = temp.split(":");
            for(int i = 0; i < ip.length; i++) {
                ips[i] = makeIP(ip[i]);
            }
        }

        String result = "";
        for(int i = 0; i < ips.length; i++) {
            result += i != 7 ? ips[i] + ":" : ips[i];
        }

        System.out.println(result);
    }

    public static String makeIP(String ip) {
        String result = ip;
        while(result.length() != 4) {
            result = "0" + result;
        }
        return result;
    }
}
