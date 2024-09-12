package week1.BOJ_14442_골드3_벽부수고이동하기2;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	

	
	static int[][] map;
	static boolean[][][] visit;
	static int N;
	static int[] dr = new int[] {1,0,-1,0};
	static int[] dc = new int[] {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M][K+1];
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		que.add(new int[] {0,0,K,1});
		visit[0][0][K] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			int r = now[0];
			int c = now[1];
			int k = now[2];
			int dist = now[3];
			if(r==N-1 && c==M-1) {
				System.out.println(dist);
				return;
			}
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nc<0 || nr>N-1 || nc>M-1)continue;
				if(map[nr][nc]==1 && k>0 && !visit[nr][nc][k-1]) {
					que.add(new int[] {nr,nc,k-1,dist+1});
					visit[nr][nc][k-1] = true;
				}else if(map[nr][nc]==0 && !visit[nr][nc][k]){
					que.add(new int[] {nr,nc,k,dist+1});
					visit[nr][nc][k] = true;
				}
				
			}
		
		}
		System.out.println(-1);
		
	}

		
}