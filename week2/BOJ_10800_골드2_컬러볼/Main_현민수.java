package week2.BOJ_10800_골드2_컬러볼;

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
	
	static class Ball implements Comparable<Ball>{
		int color;
		int size;
		int idx;
		public Ball(int color, int size,int idx) {
			this.color = color;
			this.size = size;
			this.idx = idx;
		}
		public int compareTo(Ball o) {
			if(this.size == o.size) {
				return Integer.compare(this.color, o.color);
			}
			return Integer.compare(this.size, o.size);
		}
		
	}
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Ball[] balls = new Ball[N];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(color,size,i);
		}
		int[] sameColor = new int[200001];
		int[] sameWeight = new int[2001];
		Arrays.sort(balls);
		int[] sum = new int[N];
		int[] player = new int[N];
		sum[0] = balls[0].size;
		for(int i=1;i<N;i++) {
			int temp = balls[i].size;
			sum[i] = temp + sum[i-1];
		}
		int cnt = 1;
		for(int i=0;i<N;i++) {
			int n = balls[i].idx;
			int size = balls[i].size;
			int color = balls[i].color;
			
			sameColor[balls[i].color] += size;
			sum[i] -= (sameColor[balls[i].color]+sameWeight[size]*size);
			if(i>0 && color == balls[i-1].color && size==balls[i-1].size)sum[i] = sum[i-1];
			player[n] = sum[i];
			sameWeight[size]++;
		}
		
		for(int p:player) {
			sb.append(p).append("\n");
		}
		System.out.println(sb);
		
	}




}