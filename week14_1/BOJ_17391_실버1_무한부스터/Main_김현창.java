package week14_1.BOJ_17391_실버1_무한부스터;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, 0};
	private static final int[] dy = {0, 1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] a = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(0, 0));
		int[][] visited = new int[N][M];
		visited[0][0] = 1;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int v = a[p.x][p.y];

			for (int i = 0; i < 2; ++i) {
				for (int speed = 1; speed <= v; ++speed) {
					int nx = p.x + speed * dx[i];
					int ny = p.y + speed * dy[i];
					if (nx >= N || ny >= M)
						continue;
					if (visited[nx][ny] > 0)
						continue;
					visited[nx][ny] = visited[p.x][p.y] + 1;
					queue.add(new Pair(nx, ny));
				}
			}
		}
		System.out.println(visited[N - 1][M - 1] - 1);
	    br.close();
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
