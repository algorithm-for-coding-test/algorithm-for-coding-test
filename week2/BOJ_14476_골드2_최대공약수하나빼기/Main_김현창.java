package week2.BOJ_14476_골드2_최대공약수하나빼기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] gcdFromLeft = new int[N + 1];
		int[] gcdFromRight = new int[N + 1];
		for (int i = 0; i < N; ++i) {
			gcdFromLeft[i + 1] = gcd(gcdFromLeft[i], nums[i]);
		}
		for (int i = N - 1; i >= 0; --i) {
			gcdFromRight[i] = gcd(gcdFromRight[i + 1], nums[i]);
		}

		int[] answer = {-1, -1};
		for (int i = 1; i <= N; ++i) {
			int gcd = gcd(gcdFromLeft[i - 1], gcdFromRight[i]);
			int k = nums[i - 1];
			if (k % gcd == 0)
				continue;
			if (answer[0] < gcd) {
				answer[0] = gcd;
				answer[1] = k;
			}
		}

		if (answer[0] == -1)
			System.out.println("-1");
		else
			System.out.println(answer[0] + " " + answer[1]);
	    br.close();
	}

	private static int gcd(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		if (a % b > 0) {
			return gcd(b, a % b);
		} else {
			return b;
		}
	}
}
