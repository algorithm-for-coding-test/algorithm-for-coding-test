package week1.BOJ_1987_골드4_알파벳;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int R, C;
	private static char[][] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new char[R][C];
		visited = new boolean[26];
		for (int i = 0; i < R; ++i) {
			String line = br.readLine();
			for (int j = 0; j < C; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}
		System.out.println(dfs(0, 0));
		br.close();
	}

	private static int dfs(int x, int y) {
		int res = 1;
		visited[graph[x][y] - 'A'] = true;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (visited[graph[nx][ny] - 'A'])
				continue;
			res = Math.max(res, 1 + dfs(nx, ny));
		}
		visited[graph[x][y] - 'A'] = false;
		return res;
	}
}
