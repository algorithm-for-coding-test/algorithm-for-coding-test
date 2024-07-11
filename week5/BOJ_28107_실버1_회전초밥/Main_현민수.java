package week5.BOJ_15903_실버1_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_현민수 {
	
	static class bab implements Comparable<bab>{
		int idx;
		int num;
		public bab(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
		public int compareTo(bab o) {
			if(this.num==o.num)
				return this.idx - o.idx;
			return this.num-o.num;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ans = new int[N];
        ArrayList<Integer> order = new ArrayList<Integer>();
        PriorityQueue<bab> que = new PriorityQueue<bab>();
        
        for(int i=0;i<N;i++) {
        	
        	st = new StringTokenizer(br.readLine());
        	int end = Integer.parseInt(st.nextToken());
        	for(int j=0;j<end;j++){
        		int n = Integer.parseInt(st.nextToken());
        		que.add(new bab(i,n));
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
        	int n = Integer.parseInt(st.nextToken());
        	order.add(n);
        }
        Collections.sort(order);

        for(int i=0;i<M;i++) {
        	int n = order.get(i);
        	while(true) {
        		if(que.isEmpty()) {
        			break;
        		}
        		bab temp = que.poll();
        		int idx = temp.idx;
        		int num = temp.num;
        		if(num==n) {
        			ans[idx]++;
        			break;
        		}else if(num>n) {
        			que.add(temp);
        			break;
        		}
        	}
        }
        for(int i=0;i<N;i++) {
        	sb.append(ans[i]+" ");
        }
        System.out.println(sb);
    }

    


    
}