package week1.BOJ_1194_골드1_달이차오른다가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
	static int R,C;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dr,dc;
	static int ans;
	static class move{
		int r;
		int c;
		int flag;
		public move(int r, int c, int flag) {
			super();
			this.r = r;
			this.c = c;
			this.flag = flag;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		dr = new int[] {0,0,-1,1};  //우 좌 상 하
		dc = new int[] {1,-1,0,0};
		int r=-1;
		int c=-1;
		map = new char[R][C];
		int f = 1<<6;
		visit = new boolean[R][C][f];
		for(int i=0;i<R;i++) {
			s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					r=i;
					c=j;
				}
			}
		}
		ans=0;

		bfs(r,c);
		System.out.println(ans);

	}
	static void bfs(int r, int c) {
		ArrayDeque<move> que = new ArrayDeque<>();
		que.add(new move(r,c,0));
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0;i<size;i++) {
				move temp = que.poll();
				r = temp.r;
				c = temp.c;
				

				int flag = temp.flag;
//				System.out.println(r+" "+c+" "+flag+" ["+ans+"]");
				for(int j=0;j<4;j++) {
					int nr = r+dr[j];
					int nc = c+dc[j];
					if(nr<0 || nc<0 || nr> R-1 || nc>C-1 || map[nr][nc]=='#') continue;
					if(map[nr][nc]=='1') {
						ans++;
						return;
					}
					if((map[nr][nc]=='.'|| map[nr][nc]=='0' )&& !visit[nr][nc][flag]) {
						que.add(new move(nr,nc,flag));
						visit[nr][nc][flag] = true;
					}
					
					if(97<=(int) map[nr][nc] && (int)map[nr][nc]<=102) {// 열쇠
						int key = (int)map[nr][nc]-97;

						if(!visit[nr][nc][flag | (1<<key)]) {  
							que.add(new move(nr,nc,flag | (1<<key)));
							visit[nr][nc][flag | (1<<key)] = true;
						}	
					}
					
					if(65<=(int) map[nr][nc] && (int)map[nr][nc]<=70) {  //문
						int moon = (int)map[nr][nc]-65;
						if((flag & (1<<moon))!=0 && !visit[nr][nc][flag]) {
							visit[nr][nc][flag] = true;
							que.add(new move(nr,nc,flag));
						}
					}
				}
				
			}
			ans++;
			
		}
		ans = -1;
		return;
	}

}
