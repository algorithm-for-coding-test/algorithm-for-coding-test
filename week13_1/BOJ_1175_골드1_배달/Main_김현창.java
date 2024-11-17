package week13_1.BOJ_1175_골드1_배달;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE >> 2;
	private static final int[] dx = {-1, 1, -1, 0, 0};
	private static final int[] dy = {-1, 0, 0, 1, -1};
	private static int N, M;
	private static char[][] graph;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		int sx = -1, sy = -1;
		int tx1 = -1, ty1 = -1;
		int tx2 = -1, ty2 = -1;
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j);
				if (graph[i][j] == 'S') {
					graph[i][j] = '.';
					sx = i; sy = j;
				} else if (graph[i][j] == 'C') {
					if (tx1 == -1) {
						tx1 = i; ty1 = j;
					} else {
						tx2 = i; ty2 = j;
					}
				}
			}
		}

		int[] startToTarget1 = bfs(sx, sy, 0, tx1, ty1);
		int answer = INF;
		for (int i = 1; i < 5; ++i) {
			if (startToTarget1[i] == INF)
				continue;
			answer = Math.min(answer, (startToTarget1[i] + min(bfs(tx1, ty1, i, tx2, ty2))));
		}

		int[] startToTarget2 = bfs(sx, sy, 0, tx2, ty2);
		for (int i = 1; i < 5; ++i) {
			if (startToTarget2[i] == INF)
				continue;
			answer = Math.min(answer, (startToTarget2[i] + min(bfs(tx2, ty2, i, tx1, ty1))));
		}
		System.out.println(answer == INF ? -1 : answer);
		br.close();
	}

	private static int min(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num: nums)
			min = Math.min(min, num);
		return min;
	}

	private static int[] bfs(int sx, int sy, int sDir, int tx, int ty) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(sx, sy, sDir));
		int[][][] visited = new int[N][M][5];
		visited[sx][sy][sDir] = 1;
		while (!queue.isEmpty()){
			Pair p = queue.poll();

			if (p.x == tx && p.y == ty) {
				continue;
			}

			for (int i = 1; i < 5; ++i) {
				if (p.prevDir == i)
					continue;
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny][i] != 0)
					continue;
				if (graph[nx][ny] == '#')
					continue;
				visited[nx][ny][i] = visited[p.x][p.y][p.prevDir] + 1;
				queue.add(new Pair(nx, ny, i));
			}
		}

		for (int i = 0; i < 5; ++i) {
			if (visited[tx][ty][i] == 0)
				visited[tx][ty][i] = INF;
			else --visited[tx][ty][i];
		}
		return visited[tx][ty];
	}

	private static class Pair {
		int x, y, prevDir;

		public Pair(int x, int y, int prevDir) {
			this.x = x;
			this.y = y;
			this.prevDir = prevDir;
		}
	}
}
