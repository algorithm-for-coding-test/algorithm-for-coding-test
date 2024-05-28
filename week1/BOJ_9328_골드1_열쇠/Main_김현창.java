package week1.BOJ_9328_골드1_열쇠;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int h, w;
	private static final char[][] graph = new char[102][102];
	private static String key;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		while (testcase-- > 0) {
			inputAndPreprocessing(br);
			int currKey = 0, prevKey;
			for (char c: key.toCharArray()) {
				currKey |= (1 << (c - 'a'));
			}

			int answer = 0;
			do {
				prevKey = currKey;
				int[] res = bfs(0, 0, currKey);
				currKey = res[0];
				answer = res[1];
			} while (prevKey != currKey);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

	private static int[] bfs(int x, int y, int key) {
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[h][w];
		queue.add(new Pair(x, y, key));
		visited[x][y] = true;

		int docs = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			key |= p.key;

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nKey = p.key;

				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if (graph[nx][ny] == '*')
					continue;
				if (visited[nx][ny])
					continue;
				if ('a' <= graph[nx][ny] && graph[nx][ny] <= 'z')
					nKey |= (1 << (graph[nx][ny] - 'a'));
				if ('A' <= graph[nx][ny] && graph[nx][ny] <= 'Z' && !hasKey(graph[nx][ny], nKey))
					continue;
				if (graph[nx][ny] == '$')
					++docs;

				queue.add(new Pair(nx, ny, nKey));
				visited[nx][ny] = true;
			}
		}
		return new int[]{key, docs};
	}

	private static boolean hasKey(int door, int key) {
		return (key & (1 << (door - 'A'))) > 0;
	}

	private static void inputAndPreprocessing(BufferedReader br) throws Exception {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= h; ++i) {
			String line = br.readLine();
			for (int j = 1; j <= w; ++j) {
				graph[i][j] = line.charAt(j - 1);
			}
		}
		key = br.readLine();

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
	}

	private static class Pair {
		int x, y, key;

		Pair(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
}
