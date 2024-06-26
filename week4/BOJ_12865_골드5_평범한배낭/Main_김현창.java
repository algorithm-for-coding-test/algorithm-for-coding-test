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
