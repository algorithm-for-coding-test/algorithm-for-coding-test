package week4.BOJ_1463_실버3_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];

		dp[0] = 0;
		dp[1] = 0;

		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
		}

		System.out.println(dp[N]);
	}
}