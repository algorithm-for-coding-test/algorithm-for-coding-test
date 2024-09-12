package week2.BOJ_12847_실버3_꿀아르바이트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		long temp = 0;
		long ans = 0;
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
			temp+=num[i];
			if(i>M-1) {
				temp-=num[i-M];
			}
			ans = Math.max(ans, temp);
				
		}
		
		System.out.println(ans);
	}	
	

	


}