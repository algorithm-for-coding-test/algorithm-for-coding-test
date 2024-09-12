package week2.BOJ_18870_실버2_좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main_현민수 {
	
	static ArrayList<Long> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] list = new int[N];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] ans = new int[N];
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			ans[i] = n;
			list[i] = n;
		}
		Arrays.sort(list);
		int idx = 0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(list[i]))
				map.put(list[i], idx++);
		}
		for(int i=0;i<N;i++) {
			sb.append(map.get(ans[i])).append(" ");
		}
		System.out.println(sb);
	}
	



}