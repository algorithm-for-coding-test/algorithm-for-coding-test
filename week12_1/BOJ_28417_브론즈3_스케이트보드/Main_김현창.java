package week12_1.BOJ_28417_브론즈3_스케이트보드;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] run = new int[2];
		int[] trick = new int[5];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; ++j)
				run[j] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 5; ++j)
				trick[j] = Integer.parseInt(st.nextToken());
			Arrays.sort(trick);
			answer = Math.max(answer, Math.max(run[0], run[1]) + trick[4] + trick[3]);
		}
		System.out.println(answer);
		br.close();
	}
}
