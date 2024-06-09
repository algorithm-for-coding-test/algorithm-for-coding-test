import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int N, M;
	static String[][] arr;
	static int cnt = 0;

	static class Point {
		int x, y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new String[N][M];

		for(int i=0; i<N; i++){
			arr[i] = br.readLine().split("");
		}

		bfs();

		System.out.println(cnt+2);
	}

	private static void bfs(){
		boolean[][] visit = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));

		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i=0; i<size; i++) {
				Point point = queue.poll();

				for (int j = 0; j < 4; j++) {
					int nx = point.x + dx[j];
					int ny = point.y + dy[j];

					if (nx == N - 1 && ny == M - 1)
						return;

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny])
						continue;

					visit[nx][ny] = true;

					if (arr[nx][ny].equals("1")) {
						queue.offer(new Point(nx, ny));
					}
				}
			}

			cnt++;
		}
	}
}