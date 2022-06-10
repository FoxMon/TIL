package baek.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static StringBuilder stringBuilder;
    public static int[][] edge;
    public static boolean[] isVisited;
    public static int edgeCount;
    public static int vortexCount;
    public static int startVortex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        vortexCount = scanner.nextInt();
        edgeCount = scanner.nextInt();
        startVortex = scanner.nextInt();

        edge = new int[1001][1001];
        isVisited = new boolean[1001];

        for(int i = 0; i < edgeCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            edge[x][y] = edge[y][x] = 1;
        }

        stringBuilder = new StringBuilder();
        dfs(startVortex);
        System.out.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        isVisited = new boolean[1001];
        bfs();
        System.out.println(stringBuilder.toString());
    }

    public static void dfs(int startVortex) {
        isVisited[startVortex] = true;
        stringBuilder.append(startVortex + " ");

        for(int i = 1; i <= vortexCount; i++) {
            if(edge[startVortex][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVortex);
        isVisited[startVortex] = true;
        stringBuilder.append(startVortex + " ");

        while(!queue.isEmpty()) {
            int tempEdge = queue.poll();

            for(int i = 1; i <= vortexCount; i++) {
                if(edge[tempEdge][i] == 1 && !isVisited[i]) {
                    queue.offer(i);
                    isVisited[i] = true;
                    stringBuilder.append(i + " ");
                }
            }
        }
    }
}
