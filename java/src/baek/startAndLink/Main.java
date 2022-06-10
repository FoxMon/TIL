package baek.startAndLink;

import java.util.Scanner;

public class Main {
    public static int count;
    public static int min = Integer.MAX_VALUE;
    public static int[][] startAndLink;
    public static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        startAndLink = new int[count][count];
        isVisited = new boolean[count];

        for(int i = 0; i < startAndLink.length; i++) {
            for(int j = 0; j < startAndLink[i].length; j++) {
                startAndLink[i][j] = scanner.nextInt();
            }
        }

        setStartAndLink(0, 0);
        System.out.println(min);
    }

    public static void setStartAndLink(int index, int level) {
        if(level == count / 2) {
            getPower();
            return;
        }

        for(int i = index; i < count; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                setStartAndLink(i + 1, level + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void getPower() {
        int linkPower = 0;
        int startPower = 0;

        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(isVisited[i] == true && isVisited[j] == true) {
                    startPower += startAndLink[i][j];
                    startPower += startAndLink[j][i];
                } else if(isVisited[i] == false && isVisited[j] == false) {
                    linkPower += startAndLink[i][j];
                    linkPower += startAndLink[j][i];
                }
            }
        }

        int result = Math.abs(linkPower - startPower);

        if(result == 0) {
            System.out.println(result);
            System.exit(0);
        }

        min = Math.min(min, result);
    }
}
