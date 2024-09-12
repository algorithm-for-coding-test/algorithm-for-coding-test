package week1.BOJ_2178_실버1_미로탐색;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_현민수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		boolean[][] visit = new boolean[R][C];
		int[] dr = new int[] {1,-1,0,0};
		int[] dc = new int[] {0,0,1,-1};
		for(int i=0;i<R;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<C;j++)
				map[i][j]=Integer.parseInt(s[j]);
		}
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {0,0,1});
		visit[0][0]=true;
		
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			int r = rc[0];
			int c = rc[1];
			int dist = rc[2];
			if(r==R-1 && c==C-1)
			{
				System.out.println(dist);
			}
			for(int i=0;i<4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
				if(map[nr][nc]==1 && !visit[nr][nc]) {
					queue.offer(new int[] {nr,nc,dist+1});
					visit[nr][nc]=true;
				}
			}
		}
		
	}

}