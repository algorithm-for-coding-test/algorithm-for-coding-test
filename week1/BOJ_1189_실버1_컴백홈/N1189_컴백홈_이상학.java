import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1189_컴백홈_이상학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	
	static int R, C, K;
	static char[][] map;
	static boolean[][] visit;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++) {
			
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(new int[] {R-1, 0}, 1);
		System.out.println(result);
	}
	
	static void dfs(int[] start, int distance) {
		
		if(distance == K) {
			if(start[0] == 0 && start[1] == C-1) {
				result++;
			}
			return;
		}
		
		visit[start[0]][start[1]] = true;
		
		for(int i=0; i<4; i++) {
			int x = dx[i] + start[1];
			int y = dy[i] + start[0];
			
			if((x >= 0 && x < C) && (y >= 0 && y < R)) {
				if(!visit[y][x] && map[y][x] != 'T') {
					dfs(new int[] {y, x}, distance + 1);
					visit[y][x] = false;
				}
			}
		}
	}
}
