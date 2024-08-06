package week7.BOJ_13164_골드5_행복유치원;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] pos = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			pos[i] = Integer.parseInt(st.nextToken());
		}

		int[] candidate = new int[N - 1];
		for (int i = 0; i < N - 1; ++i) {
			candidate[i] = pos[i + 1] - pos[i];
		}
		Arrays.sort(candidate);
		System.out.println(sum(candidate, 0, N - K));
	    br.close();
	}

	private static int sum(int[] arr, int left, int right) {
		int sum = 0;
		for (int i = left; i < right; ++i) {
			sum += arr[i];
		}
		return sum;
	}
}
