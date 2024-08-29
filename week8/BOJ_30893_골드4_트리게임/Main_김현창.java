package week8.BOJ_30893_골드4_트리게임;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static int N;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] prev;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        prev = new int[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        fill(E);
        System.out.println(dfs(S, 0, E) == 1 ? "First" : "Second");
        br.close();
    }

    private static void fill(int x) {
        visited[x] = true;
        for (int next: graph.get(x)) {
            if (visited[next])
                continue;
            prev[next] = x;
            fill(next);
        }
    }

    private static int dfs(int x, int turn, int target) {
        if (x == target)
            return 1;
        if (turn == 0) {
            return dfs(prev[x], 1 - turn, target);
        } else {
            if (graph.get(x).size() > 2)
                return 2;
            for (int next: graph.get(x)) {
                if (prev[next] == x)
                    continue;
                return dfs(next, 1 - turn, target);
            }
            throw new IllegalStateException();
        }
    }
}