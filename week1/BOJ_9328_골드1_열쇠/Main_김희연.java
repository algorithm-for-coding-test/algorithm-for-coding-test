package week1.BOJ_9328_골드1_열쇠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] map;
	static boolean[] key;
	static ArrayList<Point>[] door; //열지 못한 문
	static boolean[][] visit;
	static int h;
	static int w;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			String[] inputMap = br.readLine().split(" ");

			h = Integer.parseInt(inputMap[0]);
			w = Integer.parseInt(inputMap[1]);

			key = new boolean[26];
			door = new ArrayList[26];
			map = new char[h + 2][w + 2];
			visit = new boolean[h + 2][w + 2];

			cnt = 0;

			for (int i = 0; i < 26; i++) {
				door[i] = new ArrayList<>();
			}

			// 테두리 빈 칸으로 채우기
			for (int i = 0; i < h + 2; i++) {
				for (int j = 0; j < w + 2; j++) {
					map[i][j] = '.';
				}
			}

			for (int i = 1; i <= h; i++) {
				String str = br.readLine();
				for (int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j-1);
				}
			}

			String str = br.readLine();
			if (!str.equals("0")) {
				for (int i = 0; i < str.length(); i++) {
					int temp = str.charAt(i) - 'a';
					key[temp] = true;
				}
			}

			bfs();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		visit[0][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= h+2  || ny < 0 || ny >= w+2) {
					continue;
				}

				if (map[nx][ny] == '*' || visit[nx][ny]) {
					continue;
				}

				int v = map[nx][ny];
				if (v - 'A' >= 0 && v - 'A' <= 25) { //문
					if (key[v - 'A']) { //열쇠있는지 확인
						map[nx][ny] = '.';
						visit[nx][ny] = true;
						q.add(new Point(nx, ny));
					} else { //열쇠 없으면
						door[v - 'A'].add(new Point(nx, ny)); //열지 못한 문에 추가
					}
				} else if (v - 'a' >= 0 && v - 'a' <= 25) { //열쇠
					key[v - 'a'] = true;
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));

					//해당 열쇠가 열지 못한 문에 있다면 열어줌
					for (int j = 0; j <= 25; j++) {
						if (!door[j].isEmpty() && key[j]) {
							for (int z = 0; z < door[j].size(); z++) {
								Point temp = door[j].get(z);
								map[temp.x][temp.y] = '.';
								visit[temp.x][temp.y] = true;
								q.add(new Point(temp.x, temp.y));
							}
						}
					}
				} else if (v == '$') { //문서
					cnt++;
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				} else { // 빈 칸
					visit[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
}