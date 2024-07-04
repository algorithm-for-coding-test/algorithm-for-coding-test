package week1.BOJ_9328_골드1_열쇠;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	

	static int N,M;
	static char[][] map;
	static boolean[] key;
	static boolean[][] visit;
	static int[] dr = new int[] {1,0,-1,0};
	static int[] dc = new int[] {0,1,0,-1};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new boolean[N][M];
			key = new boolean[26];
			ans = 0;
			ArrayDeque<int[]> que = new ArrayDeque<int[]>();
			ArrayDeque<int[]> temp = new ArrayDeque<int[]>(); //임시
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j] = s.charAt(j);
					if(i==0 || j==0 || j==M-1 || i==N-1) {
						if(map[i][j]=='.') {
							que.add(new int[] {i,j});
							visit[i][j] = true;
						}else if(map[i][j]=='$') {
							ans++;
							visit[i][j] = true;
							que.add(new int[] {i,j}); 
						}else if(map[i][j]>='A' && map[i][j]<='Z') {
							temp.add(new int[] {i,j});
						}else if(map[i][j]>='a' && map[i][j]<='z') {
							key[map[i][j]-'a'] = true;
							visit[i][j] = true;
							que.add(new int[] {i,j}); 
						}
					}
				}
			}
			String s = br.readLine();
			if(!s.equals("0")) {
				for(int i=0,end=s.length();i<end;i++) {
					key[s.charAt(i)-'a'] = true;
				}
			}
			
			
			for(int i=0,end=temp.size();i<end;i++) {
				int[] now = temp.poll();
				int r = now[0];
				int c = now[1];
				if(key[map[r][c]-'A']) {
					que.add(new int[] {r,c});
					visit[r][c] = true;
				}else {
					temp.add(new int[] {r,c});
				}
			}
			
			while(!que.isEmpty()) {
				int[] now = que.poll();
				int r = now[0];
				int c = now[1];
				for(int i=0;i<4;i++) {
					int nr = r + dr[i];
					int nc = c+ dc[i];
					if(nr<0 || nc<0 || nr>N-1 || nc>M-1 || map[nr][nc]=='*')continue;
					if(visit[nr][nc])continue;
					if(map[nr][nc]=='.') {
						que.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}else if(map[nr][nc]=='$') {
						ans++;
						que.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}else if(map[nr][nc]>='a' && map[nr][nc]<='z') {
						que.add(new int[] {nr,nc});
						visit[nr][nc] = true;
						key[map[nr][nc]-'a'] = true;
					}else{
						temp.add(new int[] {nr,nc});
					}	
				}
				for(int i=0,end=temp.size();i<end;i++) {
					now = temp.poll();
					r = now[0];
					c = now[1];
					if(key[map[r][c]-'A']) {
						que.add(new int[] {r,c});
						visit[r][c] = true;
					}else {
						temp.add(new int[] {r,c});
					}
				}
			}
			System.out.println(ans);
			
		}
		
		
		
	}

		
}