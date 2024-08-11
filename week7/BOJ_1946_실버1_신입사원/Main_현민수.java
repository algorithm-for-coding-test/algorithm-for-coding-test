package week7.BOJ_1946_실버1_신입사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static class Rank implements Comparable<Rank>{
		int first;
		int second;
		
		public Rank(int first,int second) {
			this.first = first;
			this.second = second;
		}
		
		public int compareTo(Rank o) {
			if(this.first==o.first) {
				return Integer.compare(this.second, o.second);
			}
			return Integer.compare(this.first, o.first);
		}

		@Override
		public String toString() {
			return "Rank [first=" + first + ", second=" + second + "]";
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			Rank[] rank = new Rank[N];
			boolean[] check = new boolean[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				rank[i] = new Rank(a,b);
			}
			Arrays.sort(rank);

			int cnt = 0;
			int start = rank[0].second;
			for(int i=1;i<N;i++) {
				int now = rank[i].second;
				if(now > start)cnt++;
				else start = now; 
			}
//			for(int i=0;i<N;i++) {
//				System.out.println(rank[i].toString() + check[i]);
//			}

			System.out.println(N-cnt);
		}
		
		
		
	}
	


	
	
}