package week1.BOJ_1987_골드4_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_현민수 {
	static int R,C;
	static String[][] map;
	static int[] dr,dc;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		dr = new int[] {1,0,-1,0};
		dc = new int[] {0,1,0,-1};
		for(int i=0;i<R;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<C;j++) {
				map[i][j] = s[j];
			}
		}
		
		dfs(0,0,"");
		System.out.println(ans);
	}
	
	private static void dfs(int r, int c,String s) {
			String str=s+map[r][c];
			ans = Math.max(ans, str.length());
			for(int i=0;i<4;i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0 || nc<0 ||nr>R-1 || nc>C-1) continue;	//범위 초과
				if(str.contains(map[nr][nc])) continue;	// 방문 못함
				dfs(nr,nc,str);
			}

		}

}