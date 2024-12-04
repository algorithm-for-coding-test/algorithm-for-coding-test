package week14_1.BOJ_2456_브론즈1_나는학급회장이다;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; ++i) {
			pairs[i] = new Pair();
			pairs[i].num = i + 1;
		}

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pairs[0].score += x;
			pairs[1].score += y;
			pairs[2].score += z;
			if (x == 3) ++pairs[0].three;
			if (y == 3) ++pairs[1].three;
			if (z == 3) ++pairs[2].three;
		}

		Arrays.sort(pairs, (o1, o2) -> {
			if (o1.score != o2.score)
				return Integer.compare(o2.score, o1.score);
			return Integer.compare(o2.three, o1.three);
		});

		if (pairs[0].score == pairs[1].score && pairs[0].three == pairs[1].three) {
			System.out.println("0 " + pairs[0].score);
		} else {
			System.out.println(pairs[0].num + " " + pairs[0].score);
		}
	    br.close();
	}

	private static class Pair {
		int num, score, three;
	}
}
