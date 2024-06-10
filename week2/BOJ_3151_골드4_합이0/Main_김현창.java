package week2.BOJ_3151_골드4_합이0;

import java.io.*;
import java.util.*;

/**
 * Binary Search
 * memory 14412 kb
 * time   2744 ms
 */
public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		long answer = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				int target = -(A[i] + A[j]);
				answer += upperBound(A, j + 1, N - 1, target) - lowerBound(A, j + 1, N - 1, target);
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static int upperBound(int[] arr, int left, int right, int value) {
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] > value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left - 1;
	}

	private static int lowerBound(int[] arr, int left, int right, int value) {
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] >= value) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}

/**
 * memory 13588 kb
 * time   184 ms
 */
class AnotherSolution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] counter = new int[40040];
		long answer = 0;
		for (int i = 0; i < N; ++i) {
			answer += counter[20000 - A[i]];
			for (int j = 0; j < i; ++j) {
				++counter[20000 + A[i] + A[j]];
			}
		}
		System.out.println(answer);
		br.close();
	}
}
