package week2.BOJ_1806_골드4_부분합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int ans = Integer.MAX_VALUE;
		int temp = 0;
		
		while(end<=N) {
			if(temp<S) {
				temp+=num[end];
				end++;				
				continue;
			}
			else {
				temp -= num[start];
				start++;
				if(end-start+1<ans) {
					ans = end-start+1;
				}
				continue;
			}
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else
			System.out.println(ans);
		
		
	}

}