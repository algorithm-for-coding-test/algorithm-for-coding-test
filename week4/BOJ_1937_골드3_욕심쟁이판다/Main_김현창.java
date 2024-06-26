package week4.BOJ_1937_골드3_욕심쟁이판다;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	private static int n;
	private static int[][] graph;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; ++i)
			Arrays.fill(dp[i], -1);

		int answer = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				answer = Math.max(answer, dfs(i, j));
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static int dfs(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];

		int temp = 1;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (graph[nx][ny] >= graph[x][y])
				continue;
			temp = Math.max(temp, dfs(nx, ny) + 1);
		}
		return dp[x][y] = temp;
	}
}
