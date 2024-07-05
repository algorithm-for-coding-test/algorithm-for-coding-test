package week1.BOJ_17265_골드5_나의인생에는수학과함께;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int dx[] = {1, 0};
	static int dy[] = {0, 1};
	static int n;
	static char[][] map;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		dfs(0, 0, map[0][0] - '0');

		System.out.println(max + " " + min);
	}

	private static void dfs(int x, int y, int v) {
		if (x == n - 1 && y == n - 1) {
			min = Math.min(min, v);
			max = Math.max(max, v);
			return;
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (map[x][y] == '+') {
				dfs(nx, ny, v + (map[nx][ny] - '0'));
			} else if (map[x][y] == '-') {
				dfs(nx, ny, v - (map[nx][ny] - '0'));
			} else if (map[x][y] == '*') {
				dfs(nx, ny, v * (map[nx][ny] - '0'));
			} else
				dfs(nx, ny, v);
		}
	}
}