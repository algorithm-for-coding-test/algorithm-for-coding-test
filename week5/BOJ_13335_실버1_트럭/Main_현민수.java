package week5.BOJ_18115_실버1_트럭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static int[][] num;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		ArrayDeque<int[]> que = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int idx = 1;
		int start = num[0];
		int bridge = num[0];
		que.add(new int[] {start,1});
		while(true) {
			ans++;
			if(que.isEmpty() && idx==n)break;
			int size = que.size();
			for(int i=0;i<size;i++) {
				int[] temp = que.poll();
				int truck = temp[0];
				int nowTime = temp[1];
				if(nowTime<w) {
					que.add(new int[] {truck,nowTime+1});
				}else if(nowTime==w) {
					bridge -= truck;
				}
			}
			if(idx<n && bridge+num[idx]<=L) {
				bridge+=num[idx];
				que.add(new int[] {num[idx++],1});
			}
			
		}
		System.out.println(ans);
		
	}
	

}