import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static boolean[] visit;
	static int node, line;
	static final int START = 1;
	static List<Integer>[] nodeList;
	static int result;
	
	public static void main(String[] args) throws IOException {

		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		visit = new boolean[node+1];
		nodeList = new ArrayList[node+1];
		for(int i=1; i<=node; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			nodeList[b].add(a);
		}

		result = 0;
		dfs(START);
		System.out.println(result);
	}
	
	static void dfs(int start) {
		
		visit[start] = true;
		for(int n : nodeList[start]) {
			if(!visit[n]) {
				result++;
				dfs(n);
			}
		}
	}
}
