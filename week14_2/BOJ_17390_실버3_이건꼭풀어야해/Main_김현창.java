package week14_2.BOJ_17390_실버3_이건꼭풀어야해;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int[] acc = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			acc[i] = acc[i - 1] + A[i - 1];
		}

		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			sb.append(acc[R] - acc[L - 1]).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}
}
