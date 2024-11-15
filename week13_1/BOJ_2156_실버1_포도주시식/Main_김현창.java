package week13_1.BOJ_2156_실버1_포도주시식;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[n][3];
		dp[0][1] = arr[0];
		for (int i = 1; i < n; ++i) {
			dp[i][0] = max(dp[i - 1]);
			dp[i][1] = dp[i - 1][0] + arr[i];
			dp[i][2] = dp[i - 1][1] + arr[i];
		}
		System.out.println(max(dp[n - 1]));
	    br.close();
	}

	private static int max(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num: nums)
			max = Math.max(max, num);
		return max;
	}
}
