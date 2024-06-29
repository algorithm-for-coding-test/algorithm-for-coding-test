package week4.BOJ_12865_골드5_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] w = new int[n + 1];
		int[] v = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = dp[i - 1][j];

				if (j >= w[i]){
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
			}
		}

		int answer = 0;
		answer = bottomUp(n, k, w, v, dp);
		// answer = topDown(n, k, w, v, dp);

		System.out.println(answer);
	}

	public static int bottomUp(int n, int k, int[] w, int[] v, int[][] dp){
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if(w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		return dp[n][k];
	}

	public static int topDown(int i, int j, int[] w, int[] v, int[][] dp) {
		if (i == 0 || j == 0) {
			return 0;
		}

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		if (w[i] > j) {
			dp[i][j] = topDown(i - 1, j, w, v, dp);
		} else {
			dp[i][j] = Math.max(topDown(i - 1, j, w, v, dp), topDown(i - 1, j - w[i], w, v, dp) + v[i]);
		}

		return dp[i][j];
	}
}