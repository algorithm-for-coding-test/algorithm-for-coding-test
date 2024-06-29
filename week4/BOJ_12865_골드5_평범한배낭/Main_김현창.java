package week4.BOJ_12865_골드5_평범한배낭;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		for (int i = 1; i <= N; ++i){
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; ++i) {
			for (int j = 0; j <= K; ++j) {
				if (j - weight[i] >= 0)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println(dp[N][K]);
	    br.close();
	}
}

class AnotherSolution {

	private static int N, K;
	private static int[] weight;
	private static int[] value;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N + 1];
		value = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; ++i)
			Arrays.fill(dp[i], -1);

		System.out.println(knapsack(N, K));
		br.close();
	}

	private static int knapsack(int n, int k) {
		if (n == 0 || k <= 0)
			return 0;
		if (dp[n][k] != -1)
			return dp[n][k];
		if (weight[n] > k)
			return dp[n][k] = knapsack(n - 1, k);
		return dp[n][k] = Math.max(
			knapsack(n - 1, k - weight[n]) + value[n],
			knapsack(n - 1, k)
		);
	}
}
