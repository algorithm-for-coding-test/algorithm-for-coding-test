package week8.BOJ_16724_골드3_피리부는사나이;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static char[][] graph;
	private static int[][] visited;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j);
			}
		}

		int answer = 0;
		for (int i = 0, id = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (visited[i][j] == 0)
					answer += dfs(i, j, ++id);
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static int dfs(int x, int y, int id) {
		visited[x][y] = id;

		int d = getDirection(graph[x][y]);
		int nx = x + dx[d];
		int ny = y + dy[d];
		if (visited[nx][ny] == 0) {
			return dfs(nx, ny, id);
		} else if (visited[nx][ny] != id) {
			return 0;
		}
		return 1;
	}

	private static int getDirection(char d) {
		if (d == 'D') return 0;
		else if (d == 'U') return 1;
		else if (d == 'L') return 3;
		else if (d == 'R') return 2;
		return -1;
	}
}
