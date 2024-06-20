package week3.BOJ_16566_플래티넘5_카드게임;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] cards = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int[] cheolsu = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			cheolsu[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cards);
		boolean[] used = new boolean[M];

		StringBuilder sb = new StringBuilder();
		for (int x: cheolsu) {
			int index = lowerBound(cards, 0, M - 1, x + 1);
			while (used[index])
				++index;
			used[index] = true;
			sb.append(cards[index]).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}

	private static int lowerBound(int[] array, int left, int right, int k) {
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (array[mid] >= k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right + 1;
	}
}
