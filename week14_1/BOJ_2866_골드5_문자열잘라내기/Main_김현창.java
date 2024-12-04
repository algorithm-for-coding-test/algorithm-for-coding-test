package week14_1.BOJ_2866_골드5_문자열잘라내기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] graph = new char[R][C];
		for (int i = 0; i < R; ++i) {
			String line = br.readLine();
			for (int j = 0; j < C; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}

		int left = 0;
		int right = R - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (test(graph, R, C, mid) >= C) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
	    br.close();
	}

	private static int test(char[][] graph, int r, int c, int start) {
		Set<String> set = new HashSet<>();
		for (int j = 0; j < c; ++j) {
			StringBuilder sb = new StringBuilder();
			for (int i = start; i < r; ++i) {
				sb.append(graph[i][j]);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}
