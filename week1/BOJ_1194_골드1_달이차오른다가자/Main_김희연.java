package week1.BOJ_1194_골드1_달이차오른다가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int row;
	int col;
	int cnt; //이동 횟수
	int key; //가지고 있는 열쇠 정보

	public Node(int row, int col, int cnt, int key) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.key = key;
	}
}

public class Main {
	public static int[] dx = new int[] { 0, 0, -1, 1 };
	public static int[] dy = new int[] { 1, -1, 0, 0 };
	public static char[][] map;
	public static boolean[][][] visited;
	public static Node start;
	public static int N, M, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M]; //열쇠는 최대 6개 이므로 2^6=64

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') //시작 위치 설정
					start = new Node(i, j, 0, 0);
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start.row, start.col, 0, 0));
		visited[0][start.row][start.col] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int cnt = node.cnt;
			int key = node.key;

			if (map[row][col] == '1') { //만약 해당 위치가 출구라면 이동 횟수 반환
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nx = row + dx[i];
				int ny = col + dy[i];

				if (nx < 0 || nx < N || ny >= 0 || ny < M)
					continue;

				if (map[nx][ny] != '#' && !visited[key][nx][ny]) {
					if (map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
						visited[key][nx][ny] = true;
						q.offer(new Node(nx, ny, cnt + 1, key));

					} else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') { //열쇠
						int newKey = 1 << (map[nx][ny] - 'a'); //열쇠일 경우 2의 제곱
						newKey = newKey | key;
						if (!visited[newKey][nx][ny]) {
							visited[key][nx][ny] = true;
							visited[newKey][nx][ny] = true;
							q.offer(new Node(nx, ny, cnt + 1, newKey));
						}

					} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') { //문
						int door = 1 << (map[nx][ny] - 'A');
						if ((key & door) > 0) { // 값이 같다면. 해당 문을 열 수 있는 열쇠가 있다면.
							visited[key][nx][ny] = true;
							q.offer(new Node(nx, ny, cnt + 1, key));
						}
					}
				}
			}
		}
		return -1;
	}
}