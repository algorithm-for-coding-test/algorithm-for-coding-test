package week4.BOJ_2618_플래티넘4_경찰차;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int N, W;
	private static Pair[] events;
	private static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		events = new Pair[W + 1];
		dp = new int[W + 1][W + 1];

		for (int i = 1; i <= W; ++i) {
			st = new StringTokenizer(br.readLine());
			events[i] = new Pair(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}

		int distance = dfs(1, 0, 0);
		StringBuilder sb = new StringBuilder();
		sb.append(distance).append("\n");

		// tracing
		int eIndex1 = 0;
		int eIndex2 = 0;
		for (int i = 1; i <= W; ++i) {
			int oneDistance = getDistance(1, eIndex1, i);
			if (dp[eIndex1][eIndex2] - oneDistance == dp[i][eIndex2]) {
				eIndex1 = i;
				sb.append(1).append("\n");
			} else {
				eIndex2 = i;
				sb.append(2).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int dfs(int eIdx, int pIdx1, int pIdx2) {
		if (eIdx > W) {
			return 0;
		}
		if (dp[pIdx1][pIdx2] != 0)
			return dp[pIdx1][pIdx2];
		int res1 = dfs(eIdx + 1, eIdx, pIdx2) + getDistance(1, pIdx1, eIdx);
		int res2 = dfs(eIdx + 1, pIdx1, eIdx) + getDistance(2, pIdx2, eIdx);
		return dp[pIdx1][pIdx2] = Math.min(res1, res2);
	}

	private static int getDistance(int police, int pIdx, int eIdx) {
		Pair p1 = events[pIdx];
		Pair p2 = events[eIdx];
		if (pIdx == 0) {
			if (police == 1) {
				p1 = new Pair(1, 1);
			} else {
				p1 = new Pair(N, N);
			}
		}
		return p1.getDistance(p2);
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int getDistance(Pair o2) {
			return Math.abs(x - o2.x) + Math.abs(y - o2.y);
		}
	}
}
