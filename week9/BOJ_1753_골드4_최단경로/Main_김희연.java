package week9.BOJ_1753_골드4_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_김희연 {
    static int INF = 20000 * 10;
    static int v, e, k;
    static List<Node>[] list;
    static int[] dist;

    static class Node implements Comparable<Node>{
        int to, value;

        public Node(int to, int value){
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v+1];
        dist = new int[v+1];

        Arrays.fill(dist, INF);

        for(int i=1; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
        }

        dijkstra(k);

        for(int i=1; i<=v; i++){
            if(dist[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(int from){
        Queue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[v+1];
        pq.add(new Node(from, 0));
        dist[from] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int to = node.to;

            if(visit[to])
                continue;
            visit[to] = true;

            for(Node n : list[to]){
                if(dist[n.to] > dist[to] + n.value){
                    dist[n.to] = dist[to] + n.value;
                    pq.add(new Node(n.to, dist[n.to]));
                }
            }
        }
    }
}
