package week1.BOJ_1987_골드4_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static boolean[] visitedAlphabet = new boolean[26];
	static boolean[][] visit;
	static int maxResult = 0;
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				
				map[i][j] = str.charAt(j);
			}
		}

		visit[0][0] = true;
		visitedAlphabet[map[0][0] - 'A'] = true;
		dfs(1, 0, 0);
		
		System.out.println(maxResult);
	}
	
	static void dfs(int depth, int xP, int yP) {

		maxResult = Math.max(depth, maxResult);
		
		for(int i=0; i<4; i++) {
			
			int x = xP + dx[i];
			int y = yP + dy[i];
			
			if(x >= C || x < 0 || y >= R || y < 0) {
				continue;
			}
			if(visit[y][x] || visitedAlphabet[map[y][x] - 'A']) {
				continue;
			}
			
			visit[y][x] = true;
			visitedAlphabet[map[y][x] - 'A'] = true;
			dfs(depth+1, x, y);
			visit[y][x] = false;
			visitedAlphabet[map[y][x] - 'A'] = false;
		}
	}
}
