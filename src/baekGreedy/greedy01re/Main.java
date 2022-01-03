package baekGreedy.greedy01re;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class People implements Comparable<People> {
    private int paper;
    private int interview;

    public People(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }

    public int getPaper() { return this.paper; }
    public int getInterview() { return this.interview; }

    @Override
    public int compareTo(People people) { return this.paper - people.getPaper(); }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for(int k = 0; k < testCase; k++) {
            ArrayList<People> peoples = new ArrayList<>();
            int people = scanner.nextInt();

            for(int i = 0; i < people; i++) {
                int paper = scanner.nextInt();
                int interview = scanner.nextInt();
                peoples.add(new People(paper, interview));
            }

            Collections.sort(peoples);
            int result = 1; // paper score top 1.
            int min = peoples.get(0).getInterview();

            for(int i = 1; i < people; i++) {
                if(min > peoples.get(i).getInterview()) {
                    result++;
                    min = peoples.get(i).getInterview();
                }
            }

            System.out.println(result);
        }
    }
}
