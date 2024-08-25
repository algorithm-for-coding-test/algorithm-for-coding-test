package week8.BOJ_18310_실버3_안테나;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] pos = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			pos[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pos);
		if ((N & 1) == 0) {
			System.out.println(pos[(N >> 1) - 1]);
		} else {
			System.out.println(pos[N >> 1]);
		}
		br.close();
	}
}
