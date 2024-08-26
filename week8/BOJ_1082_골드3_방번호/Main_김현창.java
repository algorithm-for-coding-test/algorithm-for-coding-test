package week8.BOJ_1082_골드3_방번호;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		br.close();

		if (N == 1) {
			System.out.println(0);
			return;
		}

		Queue<Integer> queue = new ArrayDeque<>();
		int f = minIdx(P, 1, N);
		queue.add(f);
		M -= P[f];

		int s = minIdx(P, 0, N);
		while (M >= P[s]) {
			queue.add(s);
			M -= P[s];
		}

		List<Integer> result = new ArrayList<>(queue.size());
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = N - 1; i >= 0; --i) {
				if (M - P[i] + P[x] >= 0) {
					M -= (P[i] - P[x]);
					x = i;
					break;
				}
			}
			result.add(x);
		}

		StringBuilder sb = new StringBuilder();
		for (int x: result)
			sb.append(x);
		System.out.println(sb.toString());
	}

	private static int minIdx(int[] arr, int fromIndex, int toIndex) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = fromIndex; i < toIndex; ++i) {
			if (min > arr[i]) {
				min = arr[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
}
