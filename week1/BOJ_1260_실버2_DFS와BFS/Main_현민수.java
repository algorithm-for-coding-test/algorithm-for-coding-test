package week1.BOJ_1260_실버2_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	static boolean[] visit;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N];
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		//dfs
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(V-1);
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			if(visit[cur]) continue;
			System.out.print((cur+1)+" ");
			visit[cur]=true;
		
			for(int i=N-1;i>-1;i--) {
				if(map[cur][i]==1 && !visit[i]) {
					stack.push(i);
				}
				
			}
		}
		System.out.println();
		//bfs
		visit = new boolean[N];
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(V-1);
		visit[V-1]=true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print((cur+1)+" ");
			for(int i=0;i<N;i++) {
				if(map[cur][i]==1 && !visit[i]) {
					queue.offer(i);
					visit[i]=true;
				}
				
			}
		}
		
	}


}