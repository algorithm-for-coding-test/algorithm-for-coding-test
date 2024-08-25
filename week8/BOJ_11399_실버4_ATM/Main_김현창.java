package week8.BOJ_11399_실버4_ATM;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] P = new int[N];
		for (int i = 0; i < N; ++i) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(P);

		int answer = 0;
		int acc = 0;
		for (int i = 0; i < N; ++i) {
			acc += P[i];
			answer += acc;
		}
		System.out.println(answer);
	    br.close();
	}
}
