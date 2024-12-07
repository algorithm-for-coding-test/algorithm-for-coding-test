package week12_1.BOJ_14575_실버1_뒤풀이;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = 123456789;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Pair[] pairs = new Pair[N];
		long minimaL = 0;
		long minimaR = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			minimaL += L;
			minimaR += R;
			pairs[i] = new Pair(L, R);
		}

		int answer = INF;
		if (minimaL <= T && T <= minimaR) {
			int left = 0;
			int right = INF;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (test(pairs, T, mid)) {
					right = mid - 1;
					answer = mid;
				} else {
					left = mid + 1;
				}
			}
		}
		System.out.println(answer == INF ? -1 : answer);
		br.close();
	}

	private static boolean test(Pair[] pairs, int t, int k) {
		long more = 0;
		long minima = 0;
		for (Pair pair: pairs) {
			if (pair.l > k)
				return false;
			more += Math.min(k, pair.r) - pair.l;
			minima += pair.l;
		}
		return more >= t - minima;
	}

	private static class Pair {
		int l, r;

		Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
}
