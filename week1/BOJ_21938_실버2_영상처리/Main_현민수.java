package week1.BOJ_21938_실버2_영상처리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static int[][] map;
	static int[][] color;
	static int R,C;
	static boolean[][] visit;
	static boolean[][] visit2;
	static int[] dr = new int[] {0,0,-1,1};
	static int[] dc = new int[] {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken())*3;
		map = new int[R][C];
		color = new int[R][C/3];
		visit = new boolean[R][C/3];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int check = Integer.parseInt(br.readLine());
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j+=3) {
				int sum = (map[i][j] + map[i][j+1] + map[i][j+2])/3;
				if(sum>=check) {
					color[i][j/3] = 255;
				}else {
					color[i][j/3] = 0;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C/3;j++) {
				if(!visit[i][j] && color[i][j]==255) {
					ans++;
					bfs(i,j);
				}
			}

		}
		
		System.out.println(ans);
		
	}
	static void bfs(int r,int c) {
		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		visit[r][c] = true;
		que.add(new int[] {r,c});
		while(!que.isEmpty()) {
			int[] now = que.poll();
			r = now[0];
			c = now[1];
			
			for(int i=0;i<4;i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0 || nc<0 || nr>R-1 || nc>C/3-1)continue;
				if(visit[nr][nc] || color[nr][nc]==0)continue;
				visit[nr][nc] = true;
				que.add(new int[] {nr,nc});
			}
		}
	}

}