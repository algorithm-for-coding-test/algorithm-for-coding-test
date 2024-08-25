package week8.BOJ_13305_실버3_주유소;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N - 1];
		int[] price = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; ++i) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		long answer = 0;
		long p = 1234567890;
		for (int i = 0; i < N - 1; ++i) {
			p = Math.min(p, price[i]);
			answer += p * distance[i];
		}
		System.out.println(answer);
		br.close();
	}
}
