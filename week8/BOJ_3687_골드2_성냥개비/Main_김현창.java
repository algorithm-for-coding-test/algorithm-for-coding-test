package week8.BOJ_3687_골드2_성냥개비;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] nums = {-1, -1, 1, 7, 4, 2, 0, 8, -1, -1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(getMin(n)).append(" ")
				.append(getMax(n)).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}

	private static long getMin(int n) {
		long[] cache = new long[101];
		Arrays.fill(cache, -1);
		cache[2] = 1;
		cache[3] = 7;
		cache[4] = 4;
		cache[5] = 2;
		cache[6] = 6;
		cache[7] = 8;
		return dp(cache, n);
	}

	private static long dp(long[] cache, int n) {
		if (n == 0)
			return 0;
		if (n < 0)
			return Long.MAX_VALUE >> 8;
		if (cache[n] != -1)
			return cache[n];
		long temp = Long.MAX_VALUE >> 1;
		for (int i = 2; i < 8; ++i) {
			temp = Math.min(temp, dp(cache, n - i) * 10 + nums[i]);
		}
		return cache[n] = temp;
	}

	private static String getMax(int n) {
		StringBuilder sb = new StringBuilder();
		if ((n & 1) == 1) {
			n -= 3;
			sb.append(7);
		}
		while (n > 0) {
			n -= 2;
			sb.append(1);
		}
		return sb.toString();
	}
}
