package week8.BOJ_20413_실버2_MVP다이아몬드_Easy;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] money = new int[26];
		money['B' - 'A'] = Integer.parseInt(st.nextToken()) - 1;
		money['S' - 'A'] = Integer.parseInt(st.nextToken()) - 1;
		money['G' - 'A'] = Integer.parseInt(st.nextToken()) - 1;
		money['P' - 'A'] = Integer.parseInt(st.nextToken()) - 1;
		money['D' - 'A'] = money['P' - 'A'] + 1;

		char[] level = br.readLine().toCharArray();
		int answer = 0;
		int prev = 0;
		for (int i = 0; i < N; ++i) {
			if (level[i] == 'D') {
				answer += money['D' - 'A'];
			} else {
				int pay = money[level[i] - 'A'] - prev;
				answer += pay;
				prev = pay;
			}
		}
		System.out.println(answer);
		br.close();
	}
}