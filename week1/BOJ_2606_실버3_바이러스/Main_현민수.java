package week1.BOJ_2606_실버3_바이러스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_현민수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int link = Integer.parseInt(br.readLine());
		int[][] map = new int [N][N];
		boolean[] visit = new boolean[N];
		for(int i=0;i<link;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b]=1;
			map[b][a]=1;
		}
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(0);
		visit[0]=true;
		int ans=0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			ans++;
			for(int i=0;i<N;i++) {
				if(map[cur][i]==1 && !visit[i]) {
					queue.offer(i);
					visit[i]=true;
				}
			}
		}
		System.out.println(ans-1);

	}

}