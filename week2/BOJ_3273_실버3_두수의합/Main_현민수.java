package week2.BOJ_3273_실버3_두수의합;

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
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int X = Integer.parseInt(br.readLine());
		int ans = 0;
		int start = 0;
		int end = N-1;
		while(start<end) {
			int sum = list.get(start) + list.get(end);
			if(sum<X) {
				start++;
			}
			else if(sum>X) {
				end--;
			}else {
				int left=1;
				int right=1;
				while(start<end&& list.get(start)==list.get(start+1)) {
					left++;
					start++;
				}
				while(start<end && list.get(end)==list.get(end-1)) {
					right--;
					end--;
				}
				ans+=left*right;
				start+=left;
				end-=right;
			}
		}
		System.out.println(ans);
	}

}