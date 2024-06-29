package week4.BOJ_14916_실버5_거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] dp = new int[n+1+6];
		dp[0] = 100001;
		dp[1] = 100001;
		dp[2] = 1;
		dp[3] = 100001;
		dp[4] = 2;
		dp[5] = 1;

		for (int i = 6; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
		}

		if(dp[n] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[n]);

	}
}