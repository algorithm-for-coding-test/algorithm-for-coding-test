package week11_1.BOJ_1633_골드4_최고의팀만들기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE >> 2;
	private static int n;
	private static int[] black = new int[1010];
	private static int[] white = new int[1010];
	private static int[][][] dp = new int[1010][16][16];

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		String line;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			black[n] = Integer.parseInt(st.nextToken());
			white[n] = Integer.parseInt(st.nextToken());
			++n;
		}

		System.out.println(dfs(0, 0, 0));
	    br.close();
	}

	private static int dfs(int idx, int w, int b) {
		if (w == 15 && b == 15)
			return 0;
		if (idx == n || w == 16 || b == 16)
			return -INF;
		if (dp[idx][w][b] != 0)
			return dp[idx][w][b];

		int res1 = dfs(idx + 1, w, b);
		int res2 = dfs(idx + 1, w + 1, b) + white[idx];
		int res3 = dfs(idx + 1, w, b + 1) + black[idx];
		int t = max(res1, res2, res3);
		return dp[idx][w][b] = t > 0 ? t : -INF;
	}

	private static int max(int... nums) {
		int max = Integer.MIN_VALUE;
		for (int num: nums) {
			max = Math.max(max, num);
		}
		return max;
	}
}
