package week11_1.BOJ_1497_실버1_기타콘서트;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int N, M;
	private static long[] guitars;
	private static long maxVisit;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		guitars = new long[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // name
			String yn = st.nextToken();
			long bm = 0;
			for (int j = 0; j < M; ++j) {
				if (yn.charAt(j) == 'Y')
					bm |= (1L << j);
			}
			maxVisit |= bm;
			guitars[i] = bm;
		}
		subset(0, 0, 0);
		System.out.println(answer == 0 ? -1 : answer);
	    br.close();
	}

	private static void subset(int selected, int depth, int count) {
		if (depth == N) {
			long bm = 0;
			for (int i = 0; i < N; ++i) {
				if ((selected & (1 << i)) > 0) {
					bm |= guitars[i];
				}
			}
			if (bm == maxVisit)
				answer = Math.min(answer, count);
			return;
		}
		subset(selected | (1 << depth), depth + 1, count + 1);
		subset(selected, depth + 1, count);
	}
}
