package week4.BOJ_10971_실버2_외판원순회2;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE >> 2;

	private static int N;
	private static int fullVisit;
	private static int[][] W;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		fullVisit = (1 << N) - 1;
		W = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 1));
		br.close();
	}

	private static int dfs(int x, int visit) {
		if (visit == fullVisit) {
			return W[x][0] > 0 ? W[x][0] : INF;
		}
		int temp = INF;
		for (int i = 1; i < N; ++i) {
			if ((visit & (1 << i)) > 0)
				continue;
			if (W[x][i] == 0)
				continue;
			temp = Math.min(temp, dfs(i, visit | (1 << i)) + W[x][i]);
		}
		return temp;
	}
}
