package week4.BOJ_2294_골드5_동전2;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = 222_222_222;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		for (int i = 0; i < n; ++i) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[k + 1];
		Arrays.fill(dp, INF);
		for (int coin: coins) {
			if (coin <= k)
				dp[coin] = 1;
		}

		for (int i = 0; i <= k; ++i) {
			for (int coin: coins) {
				if (i - coin >= 0)
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		System.out.println(dp[k] == INF ? -1 : dp[k]);
	    br.close();
	}
}
