package week1.BOJ_2178_실버1_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(new int[] {0,0});
		System.out.println(map[N-1][M-1]);
	}
	
	static void bfs(int[] start) {
		
		Queue<int[]> q = new LinkedList<>();
		visit[start[0]][start[1]] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			
			start = q.poll();
			if(start[0] == N && start[1] == M) {
				break;
			}
			
			for(int i=0; i<4; i++) {
				
				int x = dx[i] + start[1];
				int y = dy[i] + start[0];
				
				if((x >= 0 && x < M) && (y >= 0 && y < N)) {
					if(!visit[y][x] && map[y][x] == 1) {
						q.add(new int[] {y, x});
						visit[y][x] = true;
						map[y][x] = map[start[0]][start[1]] + 1;
					}
				}
			}
		}
	}
}
