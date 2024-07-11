package week5.BOJ_3078_골드4_좋은친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] key = new int[21];
		int[] name = new int[N+1];
		for(int i=1;i<N+1;i++) {
			int n = br.readLine().length();
			name[i] = n;
		}
		long ans = 0;
		key[name[1]]++;
		for(int i=2;i<N+1;i++) {
			int n = name[i];
			ans += key[n]++;
			if(i>K) {
				key[name[i-K]]--;
			}
		}
		System.out.println(ans);
		
	}



}