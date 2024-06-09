package week1.BOJ_2667_실버1_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static List<Integer> villageList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					bfs(new int[] {i, j});
				}
			}
		}
		
		Collections.sort(villageList);
		System.out.println(villageList.size());
		for(int l : villageList) {
			System.out.println(l);
		}
	}
	
	static void bfs(int[] start) {
		
		Queue<int[]> q = new LinkedList<>();
		visit[start[0]][start[1]] = true;
		q.add(start);
		
		int count = 0;
		while(!q.isEmpty()) {

			count++;
			start = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = dx[i] + start[1];
				int y = dy[i] + start[0];
				
				if((x >= 0 && x < N) && (y >= 0 && y < N)) {
					if(!visit[y][x] && map[y][x] == 1) {
						q.add(new int[] {y, x});
						visit[y][x] = true;
					}
				}
			}
		}
		
		villageList.add(count);
	}
}
