package week1.BOJ_17265_골드5_나의인생에는수학과함께;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	

	
	static char[][] map;
	static boolean[][] visit;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] dr = new int[] {1,0,-1,0};
	static int[] dc = new int[] {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j*2);
			}
		}
		dfs(0,0,1,Character.getNumericValue(map[0][0]),' ');
		System.out.println(max+" "+min);
	}
	static void dfs(int r,int c,int cnt,int num,char opt) {
		
		if(cnt>N*2-1)return;
		visit[r][c] = true;
		if(r==N-1 && c==N-1) {
			max = Math.max(max,num);
			min = Math.min(min,num);
			return;
		}

		for(int i=0;i<4;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr<0 || nc<0 || nr>N-1|| nc>N-1 || visit[nr][nc])continue;
			if(Character.isDigit(map[nr][nc])) {
				int n =Character.getNumericValue(map[nr][nc]);
				if(opt=='+') {
					dfs(nr,nc,cnt+1,num+n,' ');
				}else if(opt=='-') {
					dfs(nr,nc,cnt+1,num-n,' ');
				}else if(opt=='*') {
					dfs(nr,nc,cnt+1,num*n,' ');
				}
				
			}else {
				dfs(nr,nc,cnt+1,num,map[nr][nc]);
			}
			visit[nr][nc] = false;
		}
		
	}


	
	


}