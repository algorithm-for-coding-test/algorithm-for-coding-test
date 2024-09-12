package week1.BOJ_3184_실버1_양;

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
	
	static int[][] map;
	static boolean[][] visit;
	static int R,C;
	static int sheep;
	static int wolf;
	static int[] dr = new int[] {0,0,-1,1};
	static int[] dc = new int[] {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sheep = 0;
		wolf = 0;
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				char temp = s.charAt(j);
				if(temp=='v')wolf++;
				else if(temp=='o')sheep++;
				map[i][j] = (int)temp;
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(!visit[i][j] && (map[i][j]=='v'||map[i][j]=='o')) {
					bfs(i,j);
				}
			}
		}
		System.out.println(sheep+" "+wolf);
	}
	
	static void bfs(int r,int c) {
		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		visit[r][c] = true;
		que.add(new int[] {r,c});
		int w = 0;
		int s = 0;
		if(map[r][c]=='v')w++;
		if(map[r][c]=='o')s++;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			r = now[0];
			c = now[1];
			for(int i=0;i<4;i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0 || nc<0 || nr>R-1|| nc>C-1)continue;
				if(visit[nr][nc] || map[nr][nc]=='#')continue;
				visit[nr][nc] = true;
				que.add(new int[] {nr,nc});
				if(map[nr][nc]=='v')w++;
				if(map[nr][nc]=='o')s++;
			}
		}
		if(w==0 || s==0)return;
		if(w>=s) {
			sheep -= s;
		}else {
			wolf -= w;
		}
	}
	
	
}