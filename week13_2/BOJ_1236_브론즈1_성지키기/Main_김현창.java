package week13_2.BOJ_1236_브론즈1_성지키기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] graph = new char[N][M];
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}

		int row = 0;
		int col = 0;
		for (int i = 0; i < N; ++i) {
			boolean flag = true;
			for (int j = 0; j < M; ++j) {
				if (graph[i][j] == 'X') {
					flag = false;
					break;
				}
			}
			if (flag)
				++row;
		}

		for (int j = 0; j < M; ++j) {
			boolean flag = true;
			for (int i = 0; i < N; ++i) {
				if (graph[i][j] == 'X') {
					flag = false;
					break;
				}
			}
			if (flag)
				++col;
		}
		System.out.println(Math.max(row, col));
	    br.close();
	}
}
