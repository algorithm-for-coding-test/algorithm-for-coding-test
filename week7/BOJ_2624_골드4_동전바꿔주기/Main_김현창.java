package week7.BOJ_2624_골드4_동전바꿔주기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int k;
	private static int[] p;
	private static int[] n;
	private static int[][] cache;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		p = new int[k];
		n = new int[k];
		cache = new int[T + 1][k];
		fill2D(cache, -1);

		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			n[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dp(T, 0));
	    br.close();
	}

	private static int dp(int money, int index) {
		if (money == 0)
			return 1;
		if (index >= k)
			return 0;
		if (cache[money][index] != -1)
			return cache[money][index];

		int temp = 0;
		for (int i = 0; i <= n[index]; ++i) {
			if (money - p[index] * i >= 0) {
				temp += dp(money - p[index] * i, index + 1);
			}
		}
		return cache[money][index] = temp;
	}

	private static void fill2D(int[][] array, int value) {
		for (int[] row: array)
			Arrays.fill(row, value);
	}
}
