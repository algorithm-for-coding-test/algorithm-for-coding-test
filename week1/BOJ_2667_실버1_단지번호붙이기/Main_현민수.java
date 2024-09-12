package week1.BOJ_2667_실버1_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static char[][] map;
	static boolean[][] visit;
	static int N;
	static int[] dr = new int[] {0,0,-1,1};
	static int[] dc = new int[] {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j] && map[i][j]=='1') {
					list.add(bfs(i,j));
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i);
		}
		
	}
	
	static int bfs(int r, int c) {
		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		que.add(new int[] {r,c});
		visit[r][c] = true;
		int cnt = 1;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			r = now[0];
			c = now[1];
			for(int i=0;i<4;i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0|| nc<0 || nr>N-1 || nc>N-1)continue;
				if(visit[nr][nc] || map[nr][nc]=='0')continue;
				visit[nr][nc] = true;
				cnt++;
				que.add(new int[] {nr,nc});
			}
		}
		return cnt;
	}

	
	
}