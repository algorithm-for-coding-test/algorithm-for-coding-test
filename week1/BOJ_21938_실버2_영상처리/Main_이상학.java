package week1.BOJ_21938_실버2_영상처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map;
	static int N, M, T;
	static boolean[][] visit;
	static int count;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		map = new int[N][M];

		// 물체인지 확인을 위한 map 초기화
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				double r = Double.parseDouble(st.nextToken());
				double g = Double.parseDouble(st.nextToken());
				double b = Double.parseDouble(st.nextToken());
				map[i][j] = (int) (r+g+b)/3;
			}
		}
		
		T = Integer.parseInt(br.readLine());
		count = 0;
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<M; j++) {
				
				if(map[i][j] >= T && !visit[i][j]) {
					dfs(j, i, 0);
				}
				
			}
		}
		
		System.out.println(count);
		
	}
	
	static void dfs(int startX, int startY, int depth) {
		
		visit[startY][startX] = true;
		for(int d=0; d<4; d++) {
			int x = startX + dx[d];
			int y = startY + dy[d];
			
			if((x >= 0 && x < M) && (y >= 0 && y < N)) {
				if(map[y][x] >= T && !visit[y][x]) {
					dfs(x, y, depth+1);
				}
			}
		}
		
		if(depth == 0) {
			count++;	
		}
	}
}
