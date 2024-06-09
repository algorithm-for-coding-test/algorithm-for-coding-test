import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int N;
	static int[][] node;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		node = new int[N+1][N+1];
		visit = new boolean[N+1];

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			node[a][b] = 1;
			node[b][a] = 1;
		}

		dfs(V);
		sb.append("\n");

		visit = new boolean[N+1];
		bfs(V);

		System.out.println(sb);
	}

	public static void bfs(int cur){
		Queue<Integer> queue = new LinkedList<>();
		visit[cur] = true;
		queue.offer(cur);

		while(!queue.isEmpty()){
			cur = queue.poll();
			sb.append(cur + " ");

			for(int i=1; i<=N; i++){
				if(node[cur][i] == 1 && !visit[i]){
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}

	public static void dfs(int cur){
		sb.append(cur + " ");
		visit[cur] = true;

		for(int i=1; i<=N; i++){
			if(node[cur][i] == 1 && !visit[i]){
				dfs(i);
			}
		}
	}
}