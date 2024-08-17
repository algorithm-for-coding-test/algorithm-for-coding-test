package week7.BOJ_16395_실버5_파스칼의삼각형;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
	static class path implements Comparable<path>{
		int start,end,weight;

		public path(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(path o) {
			if(Integer.compare(this.start, o.start)==0) {
				return Integer.compare(this.end, o.end);
			}
			return Integer.compare(this.start, o.start);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] dist = new int[10001];
		path[] p = new path[N];
		for(int i=0;i<D+1;i++) {
			dist[i] = i;
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			p[i] = new path(start,end,weight);
		}
		
		Arrays.sort(p);
		for(int i=0;i<N;i++) {
			path temp = p[i];
			dist[temp.end] = Math.min(dist[temp.end], dist[temp.start]+temp.weight);
			for(int j=temp.end+1;j<D+1;j++) {
				dist[j] = Math.min(dist[j],dist[temp.end] + (j-temp.end));
			}
		}
		System.out.println(dist[D]);
	}

}
