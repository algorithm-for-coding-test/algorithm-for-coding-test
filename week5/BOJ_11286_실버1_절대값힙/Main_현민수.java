package week5.BOJ_11286_실버1_절대값힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->{
			if(Math.abs(a)-Math.abs(b)==0) {
				return a-b;
			}
			return Math.abs(a)-Math.abs(b);
		});
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(que.isEmpty()) {
					sb.append(0).append("\n");
				}else sb.append(que.poll()).append("\n");
				continue;
			}
			que.add(n);
			
		}
		System.out.println(sb);
	}	
	


}