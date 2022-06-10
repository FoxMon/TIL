package baek.wareHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pillar implements Comparable<Pillar> {
    private int left;
    private int right;
    private int height;

    public Pillar(int left, int height) {
        this.left = left;
        this.right = left + 1;
        this.height = height;
    }

    public int getLeft() { return this.left; }
    public int getRight() { return this.right; }
    public int getHeight() { return this.height; }

    @Override
    public int compareTo(Pillar o) {
        return this.left - o.getLeft();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ArrayList<Pillar> pillars = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            int left = scanner.nextInt();
            int height = scanner.nextInt();
            pillars.add(new Pillar(left, height));
        }

        Collections.sort(pillars);
        Pillar pillar = pillars.get(0);
        int maxIndex = 0;
        int result = 0;

        for(int i = 1; i < pillars.size(); i++) {
            Pillar temp = pillars.get(i);
            if(pillar.getHeight() <= temp.getHeight()) {
                int width = temp.getLeft() - pillar.getLeft();
                result += width * pillar.getHeight();
                maxIndex = i;
                pillar = temp;
            }
        }

        pillar = pillars.get(pillars.size() - 1);

        for(int i = 1; i < pillars.size() - maxIndex; i++) {
            Pillar temp = pillars.get(pillars.size() - 1 - i);
            if(pillar.getHeight() <= temp.getHeight()) {
                int width = pillar.getRight() - temp.getRight();
                result += pillar.getHeight() * width;
                pillar = temp;
            }
        }

        result += pillar.getHeight();
        System.out.println(result);
    }
}
