package week2.BOJ_14476_골드2_최대공약수하나빼기;

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

	static int N;
	static int[] left,right;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		left = new int[N];
		left[0] = num[0];
		right = new int[N];
		right[N-1] = num[N-1];
		
		for(int i=1;i<N;i++) {
			left[i] = gcd(left[i-1],num[i]);
		}
		
		for(int i=N-2;i>=0;i--) {
			right[i] = gcd(right[i+1],num[i]);
		}
		
		int ans = 0;
		int idx = 0;
		for(int i=0;i<N;i++) {
			int temp = 0;
			if(i==0) {
				temp = right[1];
			}
			else if(i==N-1) {
				temp = left[N-2];
			}else {
				temp = gcd(left[i-1],right[i+1]);
			}
			if(num[i]%temp != 0 && ans<temp) {
				ans = temp;
				idx = i;
			}
		}
		if(ans==0) {
			System.out.println(-1);
		}else {
			System.out.println(ans+" "+num[idx]);
		}
	}

	static int gcd(int a,int b) {
		if(a%b==0)return b;
		return gcd(b,a%b);
	}

}