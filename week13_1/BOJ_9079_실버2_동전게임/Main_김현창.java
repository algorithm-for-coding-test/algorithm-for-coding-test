package week13_1.BOJ_9079_실버2_동전게임;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[][] flip = {
		{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
		{0, 3, 6}, {1, 4, 7}, {2, 5, 8},
		{0, 4, 8}, {2, 4, 6}
	};
	private static int[] visited = new int[(1 << 9) + 5];
	private static final int INF = Integer.MAX_VALUE;
	private static final int fullVisit = (1 << 9) - 1;
	private static int answer;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			answer = INF;
			Arrays.fill(visited, INF);
			int bm = 0;
			for (int i = 0; i < 3; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; ++j) {
					char c = st.nextToken().charAt(0);
					if (c == 'H')
						bm |= 1 << (i * 3 + j);
				}
			}
			dfs(bm, 0);
			sb.append(answer == INF ? -1 : answer).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}

	private static void dfs(int now, int depth) {
		if (now == fullVisit || now == 0) {
			answer = Math.min(answer, depth);
			return;
		}
		for (int[] f: flip) {
			int next = now;
			for (int i: f) {
				next ^= (1 << i);
			}
			if (visited[next] > depth + 1) {
				visited[next] = depth + 1;
				dfs(next, depth + 1);
			}
		}
	}
}
