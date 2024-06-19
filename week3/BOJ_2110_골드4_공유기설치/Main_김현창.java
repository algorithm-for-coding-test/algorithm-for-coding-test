package week3.BOJ_2110_골드4_공유기설치;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N];
		for (int i = 0; i < N; ++i) {
			x[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(x);

		int left = 0;
		int right = 1_111_111_111;
		while (left <= right) {
			int mid = (left + right) >> 1;
			int res = test(N, x, mid);
			if (res >= C) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left - 1);
	    br.close();
	}

	private static int test(int n, int[] x, int k) {
		int count = 0;
		int coverage = -1;
		for (int router: x) {
			if (router >= coverage) {
				++count;
				coverage = router + k;
			}
		}
		return count;
	}
}
