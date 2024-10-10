package week9.BOJ_1800_골드1_인터넷설치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_현민수 {
	
	static int N,P,K;
	static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		
		public Edge(int to,int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int[] cnt;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        cnt = new int[N+1];
        for(int i=1;i<N+1;i++) {
        	graph[i] = new ArrayList<Edge>();
        }
        int end = -1;
        for(int i=0;i<P;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	end = Math.max(end, c);
        	graph[a].add(new Edge(b,c));
        	graph[b].add(new Edge(a,c));

        }
        int start = 0;
        int ans = Integer.MIN_VALUE;
        while(start<end) {
        	int mid = (start+end)/2;
        	if(dijk(mid)) {
        		ans = mid;
        		end = mid; 
        	}else {
        		start = mid+1;
        	}
        }
        if(ans==Integer.MIN_VALUE) {
        	System.out.println(-1);
        }else
        	System.out.println(ans);
    }
    
    static boolean dijk(int mid) {
    	Arrays.fill(cnt, INF);
    	cnt[1] = 0;
    	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    	pq.add(new Edge(1,0));
    	while(!pq.isEmpty()) {
    		Edge cur = pq.poll();
    		int node = cur.to;
    		int count = cur.cost;

    		for(Edge edge:graph[node]) {
    			int nextCost = edge.cost;
    			int temp = count;
    			if(nextCost>mid) {
    				temp+=1;
    			}
    			if(cnt[edge.to]>temp) {
    				cnt[edge.to] = temp;
    				pq.add(new Edge(edge.to,temp));
    			}
    		}
    	}
    	return cnt[N]<=K;
    }
    

}