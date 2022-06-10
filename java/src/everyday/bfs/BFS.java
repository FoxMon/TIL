package everyday.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(int[] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(graph[start]);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            for(int i = 0; i < graph.length; i++) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
