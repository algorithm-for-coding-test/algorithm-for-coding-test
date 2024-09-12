package week2.BOJ_19598_골드5_최소회의실개수;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
	static class Time implements Comparable<Time>{
		int time;
		int type;
		public Time(int time,int type) {
			this.time = time;
			this.type = type;
		}
		public int compareTo(Time o) {
			if(this.time==o.time) {
				return this.type-o.type;
			}
			return this.time - o.time;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Time> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Time(start,1));
			list.add(new Time(end,-1));
		}
		Collections.sort(list);
		int ans = 0;
		int temp = 0;
		for(int i=0,end=list.size();i<end;i++) {
			temp+=list.get(i).type;
			if(list.get(i).type==1)
				ans = Math.max(ans, temp);
		}
		
		System.out.println(ans);
		
	}


	
	


}