package week2.BOJ_3020_골드5_개똥벌레;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] up = new int[H];
		int[] down = new int[H];
		for (int i = 0; i < N; ++i) {
			int o = Integer.parseInt(br.readLine());
			if ((i & 1) == 0)
				down[H - o]++;
			else
				up[o - 1]++;
		}

		for (int i = 1; i < H; ++i) {
			down[i] += down[i - 1];
		}
		for (int i = H - 2; i >= 0; --i) {
			up[i] += up[i + 1];
		}

		int[] answer = {123456789, -1};
		for (int i = 0; i < H; ++i) {
			int conflict = up[i] + down[i];
			if (answer[0] > conflict) {
				answer[0] = conflict;
				answer[1] = 1;
			} else if (answer[0] == conflict) {
				++answer[1];
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
		br.close();
	}
}
