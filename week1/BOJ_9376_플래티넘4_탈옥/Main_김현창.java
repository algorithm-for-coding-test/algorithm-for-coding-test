package week1.BOJ_9376_플래티넘4_탈옥;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int h, w;
	private static final char[][] graph = new char[102][102];

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		while (testcase-- > 0) {
			int[][] s = inputAndPreprocessing(br);
			int[][] res1 = bfs(s[0][0], s[0][1]);
			int[][] res2 = bfs(s[1][0], s[1][1]);
			int[][] res3 = bfs(0, 0);

			int answer = 12345678;
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < w; ++j) {
					if (res1[i][j] == -1 || res2[i][j] == -1 || res3[i][j] == -1)
						continue;
					answer = Math.min(answer,
						res1[i][j] + res2[i][j] + res3[i][j] - (graph[i][j] == '#' ? 2 : 0));
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}

	private static int[][] inputAndPreprocessing(BufferedReader br) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		int find = 0;
		int[][] s = new int[2][2];
		for (int i = 1; i <= h; ++i) {
			String line = br.readLine();
			for (int j = 1; j <= w; ++j) {
				graph[i][j] = line.charAt(j - 1);
				if (graph[i][j] == '$') {
					graph[i][j] = '.';
					s[find++] = new int[]{i, j};
				}
			}
		}

		// padding
		h += 2;
		w += 2;
		for (int i = 0; i < h; ++i) {
			graph[i][0] = '.';
			graph[i][w - 1] = '.';
		}
		for (int j = 0; j < w; ++j) {
			graph[0][j] = '.';
			graph[h - 1][j] = '.';
		}
		return s;
	}

	/**
	 * 0-1 BFS
	 */
	private static int[][] bfs(int x, int y) {
		Deque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y, 0));
		int[][] visited = new int[h][w];
		for (int i = 0; i < h; ++i)
			Arrays.fill(visited[i], 0, w, -1);
		visited[x][y] = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if (visited[nx][ny] != -1)
					continue;
				if (graph[nx][ny] == '*')
					continue;
				if (graph[nx][ny] == '#') {
					queue.addLast(new Pair(nx, ny, p.door + 1));
					visited[nx][ny] = p.door + 1;
				} else {
					queue.addFirst(new Pair(nx, ny, p.door));
					visited[nx][ny] = p.door;
				}
			}
		}
		return visited;
	}

	private static class Pair {
		int x, y, door;

		Pair(int x, int y, int door) {
			this.x = x;
			this.y = y;
			this.door = door;
		}
	}
}
