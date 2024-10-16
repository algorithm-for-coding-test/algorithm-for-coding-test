package week11_1.BOJ_1245_골드5_농장관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int[] dx = {0, 1, -1, 0, -1, -1, 1, 1};
	static int[] dy = {1, 0, 0, -1, -1, 1, -1, 1};
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int min = Integer.MAX_VALUE;
	static int answer = 0;

	public static class Point{
		int x, y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(visit[i][j])
					continue;
				bfs(i, j, arr[i][j]);
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int x, int y, int height){
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, y));
		boolean topFlag = true;
		visit[x][y] = true;

		while(!queue.isEmpty()){
			Point now = queue.poll();

			for(int i=0; i<8; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if(arr[nx][ny] > height)
					topFlag = false;
				else if (!visit[nx][ny] && arr[nx][ny] == height){
					visit[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}

		if(topFlag && height > min)
			answer++;
	}
}
