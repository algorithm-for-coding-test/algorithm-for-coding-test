package week2.BOJ_2559_실버3_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int temp = 0;
		for(int i=0;i<K;i++) {
			temp += num[i];
		}
		int ans = temp;
		for(int i=K;i<N;i++) {
			temp = temp + num[i] - num[i-K];
			ans = Math.max(ans, temp);
		}
		System.out.println(ans);
		
	}

	

}