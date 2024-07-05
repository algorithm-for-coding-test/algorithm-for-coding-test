package week1.BOJ_1987_골드4_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int r, c;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int max = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);

		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		if (visit[map[x][y]]) {
			max = Math.max(max, cnt);
			return;
		}

		visit[map[x][y]] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= r || ny < 0 || ny >= c)
				continue;

			dfs(nx, ny, cnt + 1);

		}
		visit[map[x][y]] = false;
	}
}