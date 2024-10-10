package week11_1.BOJ_1245_골드5_농장관리;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	private static final int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
	private static int N, M;
	private static int[][] graph;
	private static int[][] groupId;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		groupId = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int id = 0;
		List<Integer> height = new ArrayList<>();
		height.add(0);
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < M; ++y) {
				if (graph[x][y] != 0 && groupId[x][y] == 0) {
					bfs(x, y, ++id);
					height.add(graph[x][y]);
				}
			}
		}

		boolean[] checker = new boolean[id + 1];
		Arrays.fill(checker, 1, id + 1, true);
		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < M; ++y) {
				if (graph[x][y] == 0)
					continue;
				if (!checker[groupId[x][y]])
					continue;

				int h = height.get(groupId[x][y]);
				for (int i = 0; i < 8; ++i) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (groupId[nx][ny] == groupId[x][y])
						continue;
					if (height.get(groupId[nx][ny]) > h) {
						checker[groupId[x][y]] = false;
						break;
					}
				}
			}
		}

		int answer = 0;
		for (boolean b: checker)
			answer += b ? 1 : 0;
		System.out.println(answer);
	    br.close();
	}

	private static void bfs(int x, int y, int id) {
		Queue<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(x, y));
		groupId[x][y] = id;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();

			for (int i = 0; i < 8; ++i) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (groupId[nx][ny] != 0)
					continue;
				if (graph[nx][ny] != graph[x][y])
					continue;
				queue.add(new Pair(nx, ny));
				groupId[nx][ny] = id;
			}
		}
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
