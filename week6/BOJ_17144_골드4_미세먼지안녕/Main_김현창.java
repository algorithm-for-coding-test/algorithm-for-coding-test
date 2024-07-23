package week6.BOJ_17144_골드4_미세먼지안녕;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;

		 st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] A = new int[R][C];
		int[] apPosition = new int[2];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == -1) {
					apPosition = new int[] {i, j};
				}
			}
		}
		--apPosition[0];

		while (T-- > 0) {
			dust(A, R, C);
			airPurifier(A, R, C, apPosition);
		}
		System.out.println(getDust(A, R, C));
		br.close();
	}

	private static void airPurifier(int[][] graph, int r, int c, int[] position) {
		int x = position[0];
		int y = position[1];
		for (int i = x; i > 0; --i)
			graph[i][0] = graph[i - 1][0];
		for (int i = x + 1; i < r - 1; ++i)
			graph[i][0] = graph[i + 1][0];
		for (int j = 0; j < c - 1; ++j) {
			graph[0][j] = graph[0][j + 1];
			graph[r - 1][j] = graph[r - 1][j + 1];
		}
		for (int i = 0; i < x; ++i)
			graph[i][c - 1] = graph[i + 1][c - 1];
		for (int i = r - 1; i > x + 1; --i)
			graph[i][c - 1] = graph[i - 1][c - 1];
		for (int j = c - 1; j > 1; --j) {
			graph[x][j] = graph[x][j - 1];
			graph[x + 1][j] = graph[x + 1][j - 1];
		}
		graph[x][y + 1] = 0;
		graph[x + 1][y + 1] = 0;
		graph[x][y] = -1;
		graph[x + 1][y] = -1;
	}

	private static void dust(int[][] graph, int r, int c) {
		int[][] dust = new int[r][c];
		for (int x = 0; x < r; ++x) {
			for (int y = 0; y < c; ++y) {
				int d = graph[x][y] / 5;
				for (int i = 0; i < 4; ++i) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (graph[nx][ny] == -1)
						continue;
					dust[nx][ny] += d;
					graph[x][y] -= d;
				}
			}
		}
		for (int x = 0; x < r; ++x) {
			for (int y = 0; y < c; ++y)
				graph[x][y] += dust[x][y];
		}
	}

	private static int getDust(int[][] graph, int r, int c) {
		int dust = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j)
				dust += graph[i][j];
		}
		return dust + 2;
	}
}
