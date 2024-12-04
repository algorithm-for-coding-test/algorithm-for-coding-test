package week14_2.BOJ_9207_골드4_페그솔리테어;

import java.io.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static final int H = 5;
	private static final int W = 9;
	private static char[][] graph = new char[H][W];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int pins = 0;
			for (int i = 0; i < H; ++i) {
				String line = br.readLine();
				for (int j = 0; j < W; ++j) {
					graph[i][j] = line.charAt(j);
					if (graph[i][j] == 'o')
						++pins;
				}
			}
			int depth = dfs(0);
			sb.append(pins - depth).append(" ").append(depth)
				.append("\n");

			if (N > 0)
				br.readLine();
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int dfs(int depth) {
		int ret = depth;
		for (int x = 0; x < H; ++x) {
			for (int y = 0; y < W; ++y) {
				if (graph[x][y] != 'o')
					continue;
				for (int i = 0; i < 4; ++i) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nx2 = nx + dx[i];
					int ny2 = ny + dy[i];
					if (nx2 < 0 || ny2 < 0 || nx2 >= H || ny2 >= W)
						continue;
					if (graph[nx][ny] != 'o')
						continue;
					if (graph[nx + dx[i]][ny + dy[i]] != '.')
						continue;
					graph[nx + dx[i]][ny + dy[i]] = 'o';
					graph[nx][ny] = '.';
					graph[x][y] = '.';
					ret = Math.max(ret, dfs(depth + 1));
					graph[nx + dx[i]][ny + dy[i]] = '.';
					graph[nx][ny] = 'o';
					graph[x][y] = 'o';
				}
			}
		}
		return ret;
	}
}