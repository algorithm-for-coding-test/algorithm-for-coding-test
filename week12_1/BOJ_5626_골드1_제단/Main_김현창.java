package week12_1.BOJ_5626_골드1_제단;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int P = 1_000_000_007;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] h = new int[N];
		int[][] dp = new int[N][5050];
		int maxHeight = (N - 1) >> 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		if (h[0] <= 0) {
			dp[0][0] = 1;
			for (int i = 1; i < N; ++i) {
				int hMax = Math.min(Math.min(i, N - i - 1), maxHeight);
				if (h[i] == -1) {
					for (int height = 0; height <= hMax; ++height) {
						for (int k = -1; k <= 1; ++k) {
							if (0 <= height + k && height + k <= maxHeight) {
								dp[i][height] = (dp[i][height] + dp[i - 1][height + k]) % P;
							}
						}
					}
				} else {
					if (h[i] > maxHeight) {
						break;
					}
					for (int k = -1; k <= 1; ++k) {
						if (0 <= h[i] + k && h[i] + k <= maxHeight) {
							dp[i][h[i]] = (dp[i][h[i]] + dp[i - 1][h[i] + k]) % P;
						}
					}
				}
			}
		}
		System.out.println(dp[N - 1][0]);
	    br.close();
	}
}
