package week2.BOJ_1806_골드4_부분합;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = 123456789;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int answer = INF;
		int summation = 0;
		for (int left = 0, right = 0; right < N; ++right) {
			summation += nums[right];
			while (summation >= S) {
				answer = Math.min(answer, right - left + 1);
				summation -= nums[left++];
			}
		}
		System.out.println(answer == INF ? 0 : answer);
	    br.close();
	}
}
