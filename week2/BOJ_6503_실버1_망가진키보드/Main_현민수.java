package week2.BOJ_6503_실버1_망가진키보드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_현민수 {
	

	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";

		int[] check = new int[128];
		StringBuilder sb = new StringBuilder();
		while(true) {
			int m = Integer.parseInt(br.readLine());
			if(m==0)break;
			
			s = br.readLine();
			int left = 0;
			int right = 0;
			int cnt = 0;
			int ans = -1;
			while(left<=right && right<s.length()) {
				if(cnt<m) {
					if(check[s.charAt(right)]==0)cnt++;
					check[s.charAt(right)]++;
					right++;
				}else { // 같으면
					if(check[s.charAt(right)]>0) {
						check[s.charAt(right)]++;
						right++;
					}else {
						check[s.charAt(left)]--;
						if(check[s.charAt(left)]==0) {
							cnt--;
						}
						left++;
					}
				}
				ans = Math.max(ans, right-left);
			}
			Arrays.fill(check, 0);
			sb.append(ans).append("\n");
			
		}
		System.out.println(sb);
		
	}



}