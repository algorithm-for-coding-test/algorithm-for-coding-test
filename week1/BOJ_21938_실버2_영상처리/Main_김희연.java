import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static int[][] arr;
	static boolean[][] visit;
	static int T, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				int sum = 0;
				for(int k=0; k<3; k++){
					sum += Integer.parseInt(st.nextToken());
				}
				arr[i][j] = sum/3;
			}
		}

		T = Integer.parseInt(br.readLine());

		int cnt = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(dfs(i,j)) cnt++;
			}
		}

		System.out.println(cnt);

	}

	public static boolean dfs(int x,int y){
		if (x < 0 || x >= N || y < 0 || y >= M || arr[x][y] < T || visit[x][y]) {
			return false;
		}

		if (arr[x][y] >= T){
			visit[x][y] = true;
			dfs(x+1,y);
			dfs(x-1,y);
			dfs(x,y+1);
			dfs(x,y-1);
			return true;
		}

		return false;
	}
}