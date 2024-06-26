package week4.BOJ_9251_골드5_LCS;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string1 = br.readLine();
		String string2 = br.readLine();
		int n = string1.length();
		int m = string2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[n][m]);
		br.close();
	}
}
