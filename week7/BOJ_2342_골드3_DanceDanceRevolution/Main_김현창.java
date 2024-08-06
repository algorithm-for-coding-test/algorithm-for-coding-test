package week7.BOJ_2342_골드3_DanceDanceRevolution;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int n;
	private static int[] dance;
	private static int[][][] cache;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = st.countTokens() - 1;
		dance = new int[n];
		cache = new int[n][5][5];
		fill3D(cache, -1);

		for (int i = 0; i < n; ++i)
			dance[i] = Integer.parseInt(st.nextToken());

		System.out.println(solve(0, 0, 0));
	    br.close();
	}

	private static int solve(int index, int left, int right) {
		if (index >= n)
			return 0;
		if (cache[index][left][right] != -1)
			return cache[index][left][right];
		return cache[index][left][right] = Math.min(
			solve(index + 1, dance[index], right) + move(left, dance[index]),
			solve(index + 1, left, dance[index]) + move(right, dance[index])
		);
	}

	private static int move(int curr, int next) {
		if (curr == 0)
			return 2;
		if (curr == next)
			return 1;
		if (Math.abs(next - curr) == 2)
			return 4;
		return 3;
	}

	private static void fill3D(int[][][] array, int value) {
		for (int[][] one: array) {
			for (int[] two: one) {
				Arrays.fill(two, value);
			}
		}
	}
}
