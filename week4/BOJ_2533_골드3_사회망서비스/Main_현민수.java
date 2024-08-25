package week4.BOJ_2533_골드3_사회망서비스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static int N;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		dp = new int[N+1][2];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
			Arrays.fill(dp[i],Integer.MAX_VALUE>>3);
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1,0);

		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	static int dfs(int idx,int flag) {
		if(dp[idx][flag]!=Integer.MAX_VALUE>>3) {
			return dp[idx][flag];
		}

		dp[idx][0] = 0;
		dp[idx][1] = 1;

		visit[idx] = true;
		for (int child : list[idx]) {
			if (visit[child]) continue;
			dp[idx][0] += dfs(child, 1);
			dp[idx][1] += Math.min(dfs(child, 0), dfs(child, 1)); 
		}
		return dp[idx][flag];
			
	}




}