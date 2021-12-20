package backData.data02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int number = Integer.parseInt(input[0]);
        int find = Integer.parseInt(input[1]);
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            String temp = bufferedReader.readLine();
            String[] site = temp.split(" ");
            hashMap.put(site[0], site[1]);
        }

        for(int i = 0; i < find; i++) {
            String site = bufferedReader.readLine();
            if(hashMap.containsKey(site)) {
                answer.add(hashMap.get(site) + "\n");
            }
        }

        for(String result : answer) {
            System.out.print(result);
        }
    }
}
