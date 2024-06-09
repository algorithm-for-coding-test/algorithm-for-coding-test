package week1.BOJ_3184_실버1_양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	
	static int totalWolfCnt, totalSheepCnt;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
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
		
		totalWolfCnt = 0;
		totalSheepCnt = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visit[i][j] && map[i][j] != '#') {
					bfs(new int[] {i, j});
				}
			}
		}
		
		System.out.println(totalSheepCnt + " " + totalWolfCnt);
	}
	
	static void bfs(int[] start) {
		
		Queue<int[]> q = new LinkedList<>();
		visit[start[0]][start[1]] = true;
		q.add(start);
		
		int wolfCnt = 0;
		int sheepCnt = 0;
		while(!q.isEmpty()) {
			
			start = q.poll();
			if(map[start[0]][start[1]] == 'v') {
				wolfCnt++;
			}
			else if(map[start[0]][start[1]] == 'o') {
				sheepCnt++;
			}
			
			for(int i=0; i<4; i++) {
				int x = dx[i] + start[1];
				int y = dy[i] + start[0];
				
				if((x >= 0 && x < C) && (y >= 0 && y < R)) {
					if(!visit[y][x] && map[y][x] != '#') {
						q.add(new int[] {y, x});
						visit[y][x] = true;
					}
				}
			}
		}
		
		if(sheepCnt > wolfCnt) {
			totalSheepCnt += sheepCnt;
		}
		else {
			totalWolfCnt += wolfCnt;
		}
	}
}
