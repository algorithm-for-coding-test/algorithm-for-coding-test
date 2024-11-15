package week13_1.BOJ_1351_골드5_무한수열;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static Map<Long, Long> dp = new HashMap<>();

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		dp.put(0L, 1L);
		System.out.println(dfs(N, P, Q));
	    br.close();
	}

	private static long dfs(long i, int P, int Q) {
		if (dp.containsKey(i)) {
			return dp.get(i);
		}
		long v = dfs(i / P, P, Q) + dfs(i / Q, P, Q);
		dp.put(i, v);
		return v;
	}
}
