package week5.BOJ_2841_실버1_외계인의기타연주;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		Stack<Integer>[] stack = new Stack[6];
		for(int i=0;i<6;i++) {
			stack[i] = new Stack<>();
		}
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken())-1;
			int key = Integer.parseInt(st.nextToken());

			while(!stack[line].isEmpty()) {
				if(stack[line].peek()==key) {
					break;
				}
				if(stack[line].peek()<key) {
					ans++;
					stack[line].push(key);
					break;
				}
				stack[line].pop();
				ans++;
			}
			if(stack[line].isEmpty()) {
				stack[line].push(key);
				ans++;
				continue;
			}
		
		}
		System.out.println(ans);
	}



}