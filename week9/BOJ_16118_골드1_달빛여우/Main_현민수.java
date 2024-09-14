package week9.BOJ_16118_골드1_달빛여우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_현민수 {
	
	static class Edge implements Comparable<Edge>{
		int to;
		double cost;
		int type;
		public Edge(int to,double cost) {
			this.to = to;
			this.cost = cost;
		}
		public Edge(int to,double cost,int type) {
			this.to = to;
			this.cost = cost;
			this.type = type;
		}
		public int compareTo(Edge o) {
			return Double.compare(this.cost,o.cost);
		}
		
	}
	static double[] fox;
	static double[][] wolf;
	static int N;
	static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        fox = new double[N+1];
        wolf = new double[N+1][2];
        for(int i=0;i<N+1;i++) {
        	graph[i] = new ArrayList<Edge>();
        }
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	graph[a].add(new Edge(b,c));
        	graph[b].add(new Edge(a,c));
        }
        dijk(1);
        dijk2(1);
        int ans = 0;
        for(int i=2;i<N+1;i++) {
        	if(fox[i]<Math.min(wolf[i][0], wolf[i][1]))
        		ans++;
        }
        System.out.println(ans);
    }
    static void dijk(int st) {
    	Arrays.fill(fox, Integer.MAX_VALUE);
    	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    	fox[st] = 0;
    	pq.add(new Edge(st,0));
    	while(!pq.isEmpty()) {
    		Edge now = pq.poll();
    		int node = now.to;
    		double cost = now.cost;
    		if (fox[node] < cost) continue;
    		for(Edge edge:graph[node]) {
    			if(fox[edge.to]>cost+edge.cost) {
    				fox[edge.to] = cost+edge.cost;
    				pq.add(new Edge(edge.to,fox[edge.to]));
    			}
    		}
    	}
    }
    
    static void dijk2(int st) {
    	for(int i=0;i<N+1;i++) {
    		Arrays.fill(wolf[i], Integer.MAX_VALUE);
    	}
    	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    	wolf[st][0] = 0;
    	pq.add(new Edge(st,0,0));
    	while(!pq.isEmpty()) {
    		Edge now = pq.poll();
    		int node = now.to;
    		double cost = now.cost;
    		int type = now.type;
    		if(wolf[node][type]<cost)continue;
    		for(Edge edge:graph[node]) {
    			double sum;
    			if(type==0) {
    				sum = edge.cost/2 + cost;
    			}else{
    				sum = 2*edge.cost + cost;
    			}
    			if(wolf[edge.to][1-type]>sum) {
    				wolf[edge.to][1-type] = sum;
    				pq.add(new Edge(edge.to,sum,1-type));
    			}
    		}
    	}

    }
    

    

}