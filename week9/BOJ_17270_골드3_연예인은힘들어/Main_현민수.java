package week9.BOJ_17270_골드3_연예인은힘들어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_현민수 {

    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
    }

    static ArrayList<Edge>[] graph;
    static int[] leftDist;
    static int[] rightDist;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        
        leftDist = new int[V+1];
        rightDist = new int[V+1];

        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	graph[a].add(new Edge(b,cost));
        	graph[b].add(new Edge(a,cost));
        }
        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        
        dijkstra(left,leftDist);
        dijkstra(right,rightDist);
        
        int ans = -1;
        int value = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;

        for(int i=1;i<V+1;i++) {
        	if(i==left || i==right)continue;
        	int sum = leftDist[i] + rightDist[i];
        	dist = Math.min(dist, sum);
        }
        
        for(int i=1;i<V+1;i++) {
        	if(i==left || i==right)continue;
        	int sum = leftDist[i] + rightDist[i];
        	if(sum>dist)continue;
        	if(leftDist[i]>rightDist[i])continue;
        	if(value > leftDist[i]) {
        		ans = i;
        		value = leftDist[i];
        	}
        }
        System.out.println(ans);


    }

    static void addEdge(int from, int to, int cost) {
        graph[from].add(new Edge(to, cost));
        graph[to].add(new Edge(from, cost)); 
    }

    static void dijkstra(int start,int[] dist) {
       
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.to;
            if(dist[node]<cur.cost)continue;

            for (Edge edge : graph[node]) {
                int nextNode = edge.to;
                int newCost = dist[node] + edge.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new Edge(nextNode, newCost));
                }
            }
        }
    }
}