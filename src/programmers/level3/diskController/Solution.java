package programmers.level3.diskController;

import java.util.*;

class Disk {
    private int start;
    private int time;

    public Disk(int start, int time) {
        this.start = start;
        this.time = time;
    }

    public int getStart() { return this.start; }
    public int getTime() { return this.time; }
}

public class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Disk> request = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk temp1, Disk temp2) {
                return temp1.getStart() - temp2.getStart();
            }
        });
        PriorityQueue<Disk> queue = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk temp1, Disk temp2) {
                return temp1.getTime() - temp2.getTime();
            }
        });
        int count = 0;
        int sum = 0;
        int time = 0;

        for(int i = 0; i < jobs.length; i++) {
            request.offer(new Disk(jobs[i][0], jobs[i][1]));
        }

        while(count < jobs.length) {
            while(!request.isEmpty() && time >= request.peek().getStart()) {
                queue.offer(request.poll());
            }

            if(!queue.isEmpty()) {
                Disk disk = queue.poll();
                sum += disk.getTime() + (time - disk.getStart());
                time += disk.getTime();
                count++;
            } else {
                time++;
            }
        }

        int answer = sum / count;
        return answer;
    }
}