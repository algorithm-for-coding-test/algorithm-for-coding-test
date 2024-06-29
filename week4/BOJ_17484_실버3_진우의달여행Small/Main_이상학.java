package week4.BOJ_17484_실버3_진우의달여행Small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//java8 1등, java11 3등
public class Main_이상학 {
	
	static int minResult = Integer.MAX_VALUE;
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			dfs(i, 0, 0, 0);
		}
		
		System.out.println(minResult);
	}
	
	static void dfs(int x, int depth, int status, int result) {

		if(depth == N) {
			if(result < minResult) {
				minResult = result;
			}
			
			return;
		}
		for(int i=0; i<3; i++) {
			if(status == i && depth != 0) {
				continue;
			}
			if(i == 0) {
				if(x-1 < 0) {
					continue;
				}
				dfs(x-1, depth+1, i, result + map[depth][x-1]);
			}
			else if(i == 1) {
				dfs(x, depth+1, i, result + map[depth][x]);
			}
			else if(i == 2) {
				if(x+1 >= M) {
					continue;
				}
				dfs(x+1, depth+1, i, result + map[depth][x+1]);
			}
		}
	}
}
