package week1.BOJ_2606_실버3_바이러스;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // bfs
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V + 1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next: graph.get(now)) {
                if (visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
