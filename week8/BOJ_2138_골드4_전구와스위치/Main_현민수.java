package week8.BOJ_2138_골드4_전구와스위치;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	static boolean[] zero,one;
	static int N;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String now = br.readLine();
		String next = br.readLine();
		
		zero = new boolean[N];
		one = new boolean[N];

		for(int i=0;i<N;i++) {
			if(now.charAt(i)==next.charAt(i)) {
				zero[i] = true;
				one[i] = true;
			}
		}
		zero[0] = !zero[0];
		zero[1] = !zero[1];
		int a = 1;
		
		for(int i=1;i<N;i++) {
			if(!zero[i-1]) {
				press(zero,i);
				a++;
			}
		}
		int b = 0;
		for(int i=1;i<N;i++) {
			if(!one[i-1]) {
				press(one,i);
				b++;
			}
		}
		if(!zero[N-1] && !one[N-1]) {
			System.out.println(-1);
		}else if(!zero[N-1]) {
			System.out.println(b);
		}else if(!one[N-1]) {
			System.out.println(a);
		}else {
			System.out.println(Math.min(a, b));
		}
		

	}
	static void press(boolean[] arr,int idx) {
		if(idx==N-1) {
			arr[idx] = !arr[idx];
			arr[idx-1] = !arr[idx-1];
		}else {
			arr[idx+1] = !arr[idx+1];
			arr[idx] = !arr[idx];
			arr[idx-1] = !arr[idx-1];
		}
	}
}
