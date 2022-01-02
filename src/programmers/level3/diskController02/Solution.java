package programmers.level3.diskController02;

import java.util.Comparator;
import java.util.PriorityQueue;

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
            public int compare(Disk temp1, Disk temp2) { return temp1.getStart() - temp2.getStart(); }
        });

        PriorityQueue<Disk> time = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk temp1, Disk temp2) { return temp1.getTime() - temp2.getTime(); }
        });

        for(int i = 0; i < jobs.length; i++) {
            request.offer(new Disk(jobs[i][0], jobs[i][1]));
        }

        int count = 0;
        int sum = 0;
        int period = 0;

        while(count < jobs.length) {
            while(!request.isEmpty() && period >= request.peek().getStart()) {
                time.offer(request.poll());
            }

            if(!time.isEmpty()) {
                Disk disk = time.poll();
                sum += disk.getTime() + (period - disk.getStart());
                period += disk.getTime();
                count++;
            } else {
                period++;
            }
        }

        int answer = sum / count;
        return answer;
    }
}
