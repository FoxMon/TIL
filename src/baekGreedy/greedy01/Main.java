package baekGreedy.greedy01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class People implements Comparable<People> {
    private int score1;
    private int score2;

    public People(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getScore1() { return this.score1; }
    public int getScore2() { return this.score2; }
    @Override
    public int compareTo(People people) { return this.score1 - people.getScore1(); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            ArrayList<People> list = new ArrayList<>();
            int people = scanner.nextInt();

            for(int j = 0; j < people; j++) {
                int first = scanner.nextInt();
                int last = scanner.nextInt();
                list.add(new People(first, last));
            }

            Collections.sort(list);
            int result = 1;
            int min = list.get(0).getScore2();

            for(int j = 1; j < list.size(); j++) {
                if(list.get(j).getScore2() < min) {
                    result++;
                    min = list.get(j).getScore2();
                }
            }
            System.out.println(result);
        }
    }
}
