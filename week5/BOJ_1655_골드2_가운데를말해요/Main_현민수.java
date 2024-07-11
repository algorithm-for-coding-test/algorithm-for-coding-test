package week5.BOJ_1655_골드2_가운데를말해요;

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

		PriorityQueue<Integer> down = new PriorityQueue<Integer>();
		PriorityQueue<Integer> up = new PriorityQueue<Integer>((p,q)->q-p);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(i%2==0) {
				up.add(n);
			}else {
				down.add(n);
			}
			if(i==0) {
				sb.append(n).append("\n");
				continue;
			}
			if(up.peek()>down.peek()) {
				int a = up.poll();
				up.add(down.poll());
				down.add(a);
			}
			sb.append(up.peek()).append("\n");
			
		}
		System.out.println(sb);
	}
	


}