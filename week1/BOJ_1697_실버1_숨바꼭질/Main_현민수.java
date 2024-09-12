package week1.BOJ_1697_실버1_숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static int N,K;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new boolean[100001];
		int ans = bfs(N);
		System.out.println(ans);
	}
	static int bfs(int start) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {start,0});
		check[start] = true;
		while(true) {
			int[] cur = que.poll();
			int time = cur[1];
			int subin = cur[0];
			if(subin==K) {
				return time;
			}

			if(subin*2<100001 && !check[subin*2]) {
				que.offerFirst(new int[] {subin*2,time+1});
				check[subin*2] = true;
			}
			if(subin-1>-1 && !check[subin-1]) {
				que.offer(new int[] {subin-1,time+1});
				check[subin-1] = true;
			}
			if(subin+1<100001 && !check[subin+1]) {
				que.offer(new int[] {subin+1,time+1});
				check[subin+1] = true;
			}
			
			
		}
		
		
	}
}