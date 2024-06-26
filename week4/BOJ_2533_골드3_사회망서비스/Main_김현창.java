package week4.BOJ_2533_골드3_사회망서비스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * memory 426700 kb
 * time   2108 ms
 */
public class Main_김현창 {

	private static int N;
	private static List<List<Integer>> graph;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>(N + 1);
		dp = new int[N + 1][2];
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		dfs(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		br.close();
	}

	private static void dfs(int now, int previous) {
		dp[now][0] = 0;
		dp[now][1] = 1;
		for (int next: graph.get(now)) {
			if (next == previous)
				continue;
			dfs(next, now);
			dp[now][0] += dp[next][1];
			dp[now][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
}

/**
 * memory 403784 kb
 * time   1636 ms
 */
class AnotherSolution {

	private static int N, answer;
	private static List<List<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		dfs(1, -1);
		System.out.println(answer);
		br.close();
	}

	private static boolean dfs(int now, int previous) {
		if (graph.get(now).size() == 0)
			return false;

		boolean flag = true;
		for (int next: graph.get(now)) {
			if (next == previous)
				continue;
			flag &= dfs(next, now);
		}

		if (!flag)
			++answer;
		return !flag;
	}
}
