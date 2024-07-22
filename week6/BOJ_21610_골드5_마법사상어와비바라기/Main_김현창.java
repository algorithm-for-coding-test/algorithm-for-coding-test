package week6.BOJ_21610_골드5_마법사상어와비바라기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<Pair> cloud = new ArrayList<>();
		cloud.add(new Pair(N - 1, 0));
		cloud.add(new Pair(N - 1, 1));
		cloud.add(new Pair(N - 2, 0));
		cloud.add(new Pair(N - 2, 1));

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			cloudMove(cloud, N, d, s); 	// 1
			List<Pair> increased = rainfall(cloud, A);		// 2
			boolean[][] removed = removeCloud(cloud, N);	// 3
			waterCopyBug(increased, A, N);	// 4
			generateCloud(cloud, A, removed, N);	// 5
		}
		System.out.println(getSumOfWater(A, N));
	    br.close();
	}

	private static int getSumOfWater(int[][] basket, int n) {
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				sum += basket[i][j];
			}
		}
		return sum;
	}

	private static void cloudMove(List<Pair> cloud, int n, int d, int s) {
		for (Pair p: cloud) {
			p.x = (p.x + s * dx[d] + (50 * n)) % n;
			p.y = (p.y + s * dy[d] + (50 * n)) % n;
		}
	}

	private static List<Pair> rainfall(List<Pair> cloud, int[][] basket) {
		List<Pair> increased = new ArrayList<>();
		for (Pair p: cloud) {
			basket[p.x][p.y]++;
			increased.add(p);
		}
		return increased;
	}

	private static boolean[][] removeCloud(List<Pair> cloud, int n) {
		boolean[][] removed = new boolean[n][n];
		while (!cloud.isEmpty()) {
			Pair p = cloud.remove(cloud.size() - 1);
			removed[p.x][p.y] = true;
		}
		return removed;
	}

	private static void waterCopyBug(List<Pair> increased, int[][] basket, int n) {
		int[][] copy = new int[n][n];
		for (Pair p: increased) {
			int count = 0;
			for (int i = 1; i < 8; i += 2) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && basket[nx][ny] > 0)
					++count;
			}
			copy[p.x][p.y] += count;
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				basket[i][j] += copy[i][j];
		}
	}

	private static void generateCloud(List<Pair> cloud, int[][] basket, boolean[][] removed, int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (removed[i][j])
					continue;
				if (basket[i][j] >= 2) {
					basket[i][j] -= 2;
					cloud.add(new Pair(i, j));
				}
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
