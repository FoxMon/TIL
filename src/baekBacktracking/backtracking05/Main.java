package baekBacktracking.backtracking05;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static boolean[] visited;
    public static char[] word;
    public static char[] results;
    public static char[] mx;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int k = 0; k < testCase; k++) {
            word = br.readLine().toCharArray();
            visited = new boolean[word.length];
            results = new char[word.length];
            mx = new char[word.length];
            Arrays.sort(word);
            findWords(0);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void findWords(int level) throws IOException {
        if(word.length == level) {
            bw.write(results);
            bw.write("\n");
            return;
        }

        mx[level] = 0;
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i] && mx[level] < word[i]) {
                mx[level] = word[i];
                visited[i] = true;
                results[level] = word[i];
                findWords(level + 1);
                visited[i] = false;
            }
        }
    }
}
