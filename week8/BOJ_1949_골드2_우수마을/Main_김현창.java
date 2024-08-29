package week8.BOJ_1949_골드2_우수마을;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static int N;
    private static List<List<Integer>> graph;
    private static int[] people;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
            ++inDegree[a];
            ++inDegree[b];
        }

        int root = -1;
        for (int i = 1; i <= N; ++i) {
            if (inDegree[i] == 1) {
                root = i;
                break;
            }
        }

        dfs(root);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
        br.close();
    }

    private static void dfs(int x) {
        visited[x] = true;
        dp[x][0] = 0;
        dp[x][1] = people[x];
        for (int next: graph.get(x)) {
            if (visited[next])
                continue;
            dfs(next);
            dp[x][0] += Math.max(dp[next][0], dp[next][1]);
            dp[x][1] += dp[next][0];
        }
    }
}
