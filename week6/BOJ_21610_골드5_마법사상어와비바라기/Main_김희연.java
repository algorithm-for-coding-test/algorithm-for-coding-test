package week6.BOJ_21610_골드5_마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_김희연 {
	static class Point{
		int x, y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	static List<Point> cloud = new ArrayList<>();
	static int[][] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//비바라기 시전하면 비구름 생김
		cloud.add(new Point(n-1, 0));
		cloud.add(new Point(n-1, 1));
		cloud.add(new Point(n-2, 0));
		cloud.add(new Point(n-2, 1));

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());


			move(d, s); //1. 구름 이동
			List<Point> list = rain(); //2. 비가 내려 물의 양 1 증가
			boolean[][] visit = remove(); //3. 구름 제거
			waterCopyBug(list); //4. 물복사버그
			generate(visit); //5. 구름 생성 & 물 양 2 감소
		}

		int sum = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				sum += arr[i][j];
			}
		}

		System.out.println(sum);
	}

	public static void move(int d, int s){
		for(Point c: cloud){
			c.x = (n + c.x + dx[d] * (s%n)) % n;
			c.y = (n + c.y + dy[d] * (s%n)) % n;
		}
	}

	public static List<Point> rain(){
		List<Point> list = new ArrayList<>();
		for(Point c: cloud){
			arr[c.x][c.y]++;
			list.add(c);
		}
		return list;
	}

	public static boolean[][] remove(){
		boolean[][] visit = new boolean[n][n];
		for(Point c: cloud){
			visit[c.x][c.y] = true;
		}
		cloud.clear();
		return visit;
	}

	public static void waterCopyBug(List<Point> list){
		for(Point c: list){

			int cnt = 0;
			for(int i=1; i<8; i+=2){
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				if(nx < 0 || nx >=n || ny < 0 || ny >=n)
					continue;
				if(arr[nx][ny] > 0)
					cnt++;
			}
			arr[c.x][c.y] += cnt;
		}
	}

	public static void generate(boolean[][] visit){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(!visit[i][j] && arr[i][j] >= 2){
					cloud.add(new Point(i, j));
					arr[i][j] -= 2;
				}
			}
		}
	}
}
