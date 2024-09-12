package week1.BOJ_3184_실버1_스타트링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {
	

	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(S);
		int ans = 0;
		boolean flag = false;
		boolean[] visit = new boolean[F+1];
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				int n = que.poll();
				if(n==G) {
					System.out.println(ans);
					flag = true;
					break;
				}
				if(n+U<=F && !visit[n+U]) {
					que.add(n+U);
					visit[n+U] = true;
				}
				if(n-D>=1 && !visit[n-D]) {
					que.add(n-D);
					visit[n-D] = true;
				}
			}
			ans++;
			if(flag) {
				return;
			}
		}
		System.out.println("use the stairs");
		
	}

	

}