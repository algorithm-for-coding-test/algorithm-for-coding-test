package week11_2.BOJ_2246_브론즈1_콘도선정;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Condo[] condos = new Condo[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			condos[i] = new Condo(i, D, C);
		}

		boolean[] candidate = new boolean[N];
		Arrays.fill(candidate, true);

		Arrays.sort(condos, (o1, o2) -> {
			if (o1.d != o2.d)
				return Integer.compare(o1.d, o2.d);
			return Integer.compare(o2.c, o1.c);
		});

		int cost = Integer.MAX_VALUE;
		for (Condo condo: condos) {
			if (cost <= condo.c) {
				candidate[condo.num] = false;
			}
			cost = Math.min(cost, condo.c);
		}

		Arrays.sort(condos, (o1, o2) -> {
			if (o1.c != o2.c)
				return Integer.compare(o1.c, o2.c);
			return Integer.compare(o2.d, o1.d);
		});

		int distance = Integer.MAX_VALUE;
		for (Condo condo: condos) {
			if (distance <= condo.d) {
				candidate[condo.num] = false;
			}
			distance = Math.min(distance, condo.d);
		}
		System.out.println(countTrue(candidate));
		br.close();
	}

	private static int countTrue(boolean[] booleans) {
		int count = 0;
		for (boolean b: booleans)
			count += b ? 1 : 0;
		return count;
	}

	private static class Condo {
		int num, d, c;

		Condo(int num, int d, int c) {
			this.num = num;
			this.d = d;
			this.c = c;
		}
	}
}