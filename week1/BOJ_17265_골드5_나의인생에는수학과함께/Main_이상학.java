package week1.BOJ_17265_골드5_나의인생에는수학과함께;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * max값이 -가 될 것을 간과하고 0으로 초기화하는 실수를 했따
 */
public class Main_이상학 {

	static char[][] map;
	static long maxResult = Long.MIN_VALUE;
	static long minResult = Long.MAX_VALUE;
	static int N;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		dfs(1, map[0][0] - '0', 0, 0, 'n');
		
		System.out.println(maxResult + " " + minResult);
	}
	
	static void dfs(int depth, long result, int xP, int yP, char mark) {

		if(depth == N*2-1) {
			if(xP != N-1 || yP != N-1) {
				return;
			}
			maxResult = Math.max(result, maxResult);
			minResult = Math.min(result, minResult);
		}
		
		for(int i=0; i<2; i++) {
			
			int x = xP + dx[i];
			int y = yP + dy[i];
			
			if(x >= N || y >= N) {
				continue;
			}
			
			if(mark == 'n') {
				dfs(depth+1, result, x, y, map[y][x]);
			}
			else {
				if(mark == '+') {
					dfs(depth+1, result + (map[y][x] - '0'), x, y, 'n');
				}
				else if(mark == '-') {
					dfs(depth+1, result - (map[y][x] - '0'), x, y, 'n');
				}
				else if(mark == '*') {
					dfs(depth+1, result * (map[y][x] - '0'), x, y, 'n');
				}
			}
		}
	}
}
