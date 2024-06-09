import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18126_김희연 {

	static class Edge{
		int to;
		int dis;
		public Edge(int to, int dis){
			this.to = to;
			this.dis = dis;
		}
	}

	static List<Edge>[] graph;
	static boolean[] visit;
	static long answer=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N+1];
		visit = new boolean[N+1];

		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<>();
		}

		for(int i=1; i<=N-1; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
		}

		visit[1] = true;
		dfs(1, 0);
		System.out.println(answer);
	}

	public static void dfs(int cur, long dis){
		if(answer < dis)
			answer = dis;

		for(Edge edge : graph[cur]){
			if(visit[edge.to])
				continue;
			visit[edge.to] = true;
			dfs(edge.to, dis + edge.dis);
		}
	}
}