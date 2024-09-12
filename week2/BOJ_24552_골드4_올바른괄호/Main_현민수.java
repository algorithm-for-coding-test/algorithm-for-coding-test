package week2.BOJ_24552_골드4_올바른괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_현민수 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//노드 수
		int d = Integer.parseInt(st.nextToken());	//초밥번호
		int k = Integer.parseInt(st.nextToken());	//깊이 수
		int c = Integer.parseInt(st.nextToken());	//쿠폰
		
		int[] node = new int[N*2];
		int[] visit = new int[d+1];
		for(int i=0;i<N;i++) {
			node[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N;i<2*N;i++) {
			node[i] = node[i-N];
		}
		
		int cnt=0;
		for(int i=0;i<k;i++) {
			if(visit[node[i]]==0) {
				visit[node[i]]+=1;
				cnt++;
			}
			else {
				visit[node[i]]+=1;
			}
		}
		
		int ans=cnt;
		for(int i=0;i<N;i++) {
			visit[node[i]]--;
			if(visit[node[i]]==0)cnt--;
			visit[node[k+i]]++;
			if(visit[node[k+i]]==1)cnt++;		
			if(visit[c]==0) {
				ans = Math.max(cnt+1,ans);	
			}
			else {
				ans = Math.max(cnt,ans);
			}
		}
		System.out.println(ans);

	
	}
}