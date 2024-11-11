package week11_2.BOJ_2876_실버3_그래픽스퀴즈;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] chk = new int[6][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			chk[A][i] = 1;
			chk[B][i] = 1;
		}

		int[] result = new int[2];
		int[] dp = new int[N];
		for (int i = 1; i < 6; ++i) {
			Arrays.fill(dp, 0);
			dp[0] = chk[i][0];
			for (int j = 1; j < N; ++j) {
				if (chk[i][j] == 0)
					continue;
				if (chk[i][j - 1] == 1)
					dp[j] = dp[j - 1] + 1;
				else dp[j] = 1;
			}
			int cnt = getMax(dp);
			if (cnt > result[0]) {
				result[0] = cnt;
				result[1] = i;
			}
		}
		System.out.println(result[0] + " " + result[1]);
		br.close();
	}

	private static int getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int num: nums) {
			max = Math.max(max, num);
		}
		return max;
	}
}
