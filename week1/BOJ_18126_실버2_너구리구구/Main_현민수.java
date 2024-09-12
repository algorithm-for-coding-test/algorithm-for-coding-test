package week1.BOJ_18126_실버2_너구리구구;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static class  Node{
		int num;
		long dist;
		public Node(int num, long dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	static long ans;
	static boolean[] visit;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		ans = 0;
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long d = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,d));
			list[b].add(new Node(a,d));
		}
		
		dfs(1,0);
		System.out.println(ans);
	}
	static void dfs(int start, long dist) {
	    visit[start] = true; 
	    for (Node node : list[start]) {
	        int n = node.num;
	        long d = node.dist;
	        if (!visit[n]) {
	            dfs(n, dist + d);
	        }
	    }
	    ans = Math.max(ans, dist);
	    visit[start] = false; 
	}

}