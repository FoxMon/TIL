package practice3.test01;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = Integer.parseInt(input);
        int[][] rect = new int[size][size];
        int cnt = 1;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                rect[j][i] = cnt++;
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(rect[i][j] + " ");
            }

            System.out.println();
        }
    }
}
