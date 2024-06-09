import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[][] pair;
	static boolean[] visit;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		pair = new boolean[n+1][n+1];
		visit = new boolean[n+1];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pair[a][b] = true;
			pair[b][a] = true;
		}

		dfs(1);
		System.out.println(cnt);
	}

	public static void dfs(int depth){
		visit[depth] = true;

		for(int i=1; i<=n; i++) {
			if (pair[depth][i] && !visit[i]){
				cnt++;
				dfs(i);
			}
		}
	}
}