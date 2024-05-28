package week1.BOJ_1194_골드1_달이차오른다가자;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static final char EXIT = '1';

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] graph = new char[N][M];
		Pair start = new Pair(-1, -1, 0, 0);
		for (int i = 0; i < N; ++i) {
			String line = br.readLine();
			for (int j = 0; j < M; ++j) {
				graph[i][j] = line.charAt(j);
				if (graph[i][j] == '0') {
					start.x = i;
					start.y = j;
					graph[i][j] = '.';
				}
			}
		}

		int answer = -1;
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][1 << 6];
		queue.add(start);
		visited[start.x][start.y][0] = true;
		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			if (graph[p.x][p.y] == EXIT) {
				answer = p.count;
				break;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nKey = p.key;
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (graph[nx][ny] == '#')
					continue;
				if ('a' <= graph[nx][ny] && graph[nx][ny] <= 'f')
					nKey |= (1 << (graph[nx][ny] - 'A'));
				if ('A' <= graph[nx][ny] && graph[nx][ny] <= 'F' && !hasKey(graph[nx][ny], nKey))
					continue;
				if (visited[nx][ny][nKey])
					continue;
				visited[nx][ny][nKey] = true;
				queue.add(new Pair(nx, ny, nKey, p.count + 1));
			}
		}
		System.out.println(answer);
	    br.close();
	}

	private static boolean hasKey(int door, int key) {
		return (key & (1 << (door - 'A'))) > 0;
	}

	private static class Pair {
		int x, y, key, count;

		Pair(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	}
}
