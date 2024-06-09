import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_김희연 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<N; j++){
				map[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j] == 1){
					cnt = 1;
					map[i][j] = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}

		sb.append(list.size() + "\n");
		Collections.sort(list);

		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i) + "\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int x, int y){
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >=N || ny < 0 || ny >= N) continue;

			if(map[nx][ny] == 1){
				map[nx][ny] = 0;
				cnt++;
				dfs(nx, ny);
			}
		}
	}
}