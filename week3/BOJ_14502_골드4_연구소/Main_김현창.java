package week3.BOJ_14502_골드4_연구소;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int N, M, answer;
	private static int countOfCells;
	private static int[][] graph;
	private static List<Pair> virusList;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		countOfCells = N * M;
		graph = new int[N][M];
		virusList = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 2)
					virusList.add(new Pair(i, j));
			}
		}
		dfs(0, 0);
		System.out.println(answer);
	    br.close();
	}

	private static void dfs(int index, int count) {
		if (count == 3) {
			answer = Math.max(answer, test());
			return;
		}
		if (index >= countOfCells) {
			return;
		}
		int r = index / M;
		int c = index % M;
		if (graph[r][c] == 0) {
			graph[r][c] = 1;
			dfs(index + 1, count + 1);
			graph[r][c] = 0;
		}
		dfs(index + 1, count);
	}

	private static int test() {
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		for (Pair virus: virusList) {
			queue.add(virus);
			visited[virus.x][virus.y] = true;
		}
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < 4; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (visited[nx][ny])
					continue;
				if (graph[nx][ny] >= 1)
					continue;
				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (!visited[i][j] && graph[i][j] == 0)
					++count;
			}
		}
		return count;
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
