package practice.fileSort;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String temp1, String temp2) {
                String header1 = temp1.split("[0-9]")[0];
                String header2 = temp2.split("[0-9]")[0];
                int result = header1.toLowerCase().compareTo(header2.toLowerCase());

                if (result == 0) {
                    result = contrastNumber(temp1, header1) - contrastNumber(temp2, header2);
                }

                return result;
            }
        });

        return files;
    }

    public int contrastNumber(String temp, String header) {
        String result = "";
        temp = temp.substring(header.length());

        for(char ch : temp.toCharArray()) {
            if(Character.isDigit(ch) && result.length() < 5) {
                result += ch;
            } else {
                break;
            }
        }

        return Integer.valueOf(result);
    }
}
