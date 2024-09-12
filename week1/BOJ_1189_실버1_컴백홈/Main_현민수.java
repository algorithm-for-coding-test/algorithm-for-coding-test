package week1.BOJ_1189_실버1_컴백홈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static int R,C;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = new int[] {0,0,-1,1};
	static int[] dc = new int[] {1,-1,0,0};
	static int K;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		dfs(R-1,0,1);
		System.out.println(ans);
	}
	static void dfs(int r,int c,int dist) {
		if(r==0 && c==C-1) {
			if(dist==K)ans++;
			return;
		}
		visit[r][c] = true;
		for(int i=0;i<4;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr<0 || nc<0 || nr>R-1 || nc>C-1)continue;
			if(visit[nr][nc])continue;
			if(map[nr][nc]=='T')continue;
			dfs(nr,nc,dist+1);
			visit[nr][nc] = false;
		}
		
	}
	

}
