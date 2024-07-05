package week1.BOJ_14442_골드3_벽부수고이동하기2;

import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	int cnt;
	int dist;

	Node(int x, int y, int cnt, int dist){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dist = dist;
	}
}

public class Main_김희연 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int map[][];
	static boolean visit[][][];
	static int n, m, k;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new boolean[n][m][k+1];

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();

		System.out.println(answer);
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0,0,0,1));
		visit[0][0][0] = true;

		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;

			if(x == n-1 && y == m-1) {
				answer = node.dist;
				return;
			}

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx < 0|| nx >= n || ny < 0 || ny >= m)
					continue;

				if(map[nx][ny] == 0 && !visit[nx][ny][node.cnt]) { //그냥 이동하기
					visit[nx][ny][node.cnt] = true;
					q.add(new Node(nx, ny, node.cnt, node.dist+1));
				}else {
					if(node.cnt < k && !visit[nx][ny][node.cnt+1]) { //벽 부수고 이동하기
						visit[nx][ny][node.cnt+1] = true;
						q.add(new Node(nx, ny, node.cnt+1, node.dist+1));
					}
				}
			}
		}
	}
}