package week3.BOJ_2805_실버2_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		int[] height = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(height);

		long mid = 0;
		long start = 0;
		long end = height[height.length - 1];
		long answer = 0;

		while (start < end) {
			mid = (start + end) / 2;

			if (func(height, N, mid) < M) {
				end = mid;
			} else {
				start = mid + 1;
				answer = mid;
			}
		}

		System.out.println(answer);
	}

	private static long func(int[] height, int N, long mid) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (height[i] > mid) {
				sum += height[i] - mid;
			}
		}
		return sum;
	}
}