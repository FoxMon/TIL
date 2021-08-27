package practice3.rectangleCount;

import java.io.*;

public class Main {
    public static long getCount(long size) {
        long count = 0;

        for(long i = 0; i <= size; i++) {
            count += i * i;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long size = Integer.parseInt(input);
        long answer = 0;

        answer += getCount(size);

        System.out.println(answer);
    }
}