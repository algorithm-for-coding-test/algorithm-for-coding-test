package week12_2.BOJ_14220_골드3_양아치집배원;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE >> 2;
	private static int n;
	private static int[][] cost;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = INF;
		for (int i = 0; i < n; ++i) {
			answer = Math.min(answer, dfs(i, 1));
		}
		System.out.println(answer == INF ? -1 : answer);
		br.close();
	}

	private static int dfs(int x, int passCount) {
		if (passCount == n)
			return 0;
		if (dp[x][passCount] != 0)
			return dp[x][passCount];

		int ret = INF;
		for (int i = 0; i < n; ++i) {
			if (i == x || cost[x][i] == 0)
				continue;
			ret = Math.min(ret, dfs(i, passCount + 1) + cost[x][i]);
		}
		return dp[x][passCount] = ret;
	}
}