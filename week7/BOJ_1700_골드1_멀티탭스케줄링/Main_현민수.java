package week7.BOJ_1700_골드1_멀티탭스케줄링;

import java.io.*;
import java.util.*;

public class Main_현민수 {
	
	static int N,K;
	static int[] plugs;
	static ArrayDeque<Integer> que;
	static int ans = 0;
	static boolean[] visit;
	static class Rank implements Comparable<Rank>{
		int num;
		int order;
		public Rank(int num, int order) {
			this.num = num;
			this.order = order;
		}
		public int compareTo(Rank o) {
			return Integer.compare(o.order,this.order);
		}
		
	}
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    StringBuilder sb = new StringBuilder();
	
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    plugs = new int[K];
	    visit = new boolean[101];
	    que  = new ArrayDeque<Integer>();
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<K;i++) {
	    	plugs[i] = Integer.parseInt(st.nextToken());
	    }
	    for(int i=0;i<K;i++) {
	    	int n = plugs[i];
	    	int size = que.size();
	    	if(size < N ) {
	    		if(!visit[n])
	    			que.add(n);
	    		visit[n] = true;
	    		continue;
	    	}
	    	if(!visit[n] && size==N) {
	    		find(i);
	    		ans++;
	    		que.add(n);
	    		visit[n] = true;
	    	}
//	    	System.out.println(plugs[i]+" "+size+" "+Arrays.toString(visit));
	    }
	    System.out.println(ans);

    }
    static void find(int idx) {
    	PriorityQueue<Rank> ranks = new PriorityQueue<Rank>();
    	for(int i=0;i<N;i++) {
    		int n = que.poll();
    		for(int j=idx;j<K;j++) {
    			if(n==plugs[j]) {
    				ranks.add(new Rank(n,j));
    				break;
    			}
    			if(K-1==j) {
    				ranks.add(new Rank(n,1000));
    			}
    		}
    		
    	}
    	int end = ranks.poll().num;
    	visit[end] = false;
    	for(int i=1;i<K+1;i++) {
    		if(visit[i]) {
    			que.add(i);
    		}
    	}

    }

}
