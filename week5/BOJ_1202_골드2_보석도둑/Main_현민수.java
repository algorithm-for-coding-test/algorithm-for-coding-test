package week5.BOJ_1202_골드2_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static class jewerly implements Comparable<jewerly>{
		int weight;
		int price;
		public jewerly(int weight,int price) {
			this.weight = weight;
			this.price = price;
		}
		public int compareTo(jewerly o) {
			if(o.weight==this.weight)return o.price-this.price;
			return this.weight-o.weight;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long answer = 0;
		jewerly[] jew = new jewerly[n];
		int[] back = new int[k];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			jew[i] = new jewerly(w, p);
		}
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			back[i] = b;
		}
		Arrays.sort(jew);
		Arrays.sort(back);
		PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->b-a);
		int j=0;
        for(int i=0; i<k; i++) {
        	while(j<n) {
        		int p = jew[j].price;
        		int w = jew[j].weight;
        		if(back[i]<w) break;
        		que.add(p);
        		j++;
        	}
        	if(!que.isEmpty()) answer+=que.poll();
        }
        System.out.println(answer);
	}

	

}