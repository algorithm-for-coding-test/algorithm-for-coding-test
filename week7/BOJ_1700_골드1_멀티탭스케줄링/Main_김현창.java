package week7.BOJ_1700_골드1_멀티탭스케줄링;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = 9999;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] tab = new int[N];
		int[] item = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		int used = 0;
		int answer = 0;
		for (int i = 0; i < K; ++i) {
			int index = findIndex(tab, 0, N, item[i]);
			if (index != INF)
				continue;
			if (used < N) {
				tab[used++] = item[i];
				continue;
			}

			++answer;
			int bestJ = -1;
			int farthest = -1;
			for (int j = 0; j < N; ++j) {
				int k = findIndex(item, i + 1, K, tab[j]);
				if (farthest < k) {
					farthest = k;
					bestJ = j;
				}
			}
			tab[bestJ] = item[i];
		}
		System.out.println(answer);
	    br.close();
	}

	private static int findIndex(int[] array, int left, int right, int value) {
		for (int i = left; i < right; ++i) {
			if (array[i] == value) {
				return i;
			}
		}
		return INF;
	}
}
