package week7.BOJ_1446_실버1_지름길;

import java.io.*;
import java.util.*;

/** top-down 버전 **/
public class Main_김희연 {
    static int n, d;
    static List<Node>[] list;
    static int[] dp;

    private static class Node{
        int to, cost;

        private Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        list = new List[d+1];
        for(int i=0; i<=d; i++)
            list[i] = new ArrayList<>();

        dp = new int[d+1];
        Arrays.fill(dp, -1);

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b <= d)
                list[b].add(new Node(a, c));
        }

        System.out.println(topDown(d));
    }

    private static int topDown(int x){
        if(x == 0)
            return 0;
        if(dp[x] != -1)
            return dp[x];

        dp[x] = topDown(x-1) + 1;
        for(Node next : list[x]){
            dp[x] = Math.min(dp[x], topDown(next.to) + next.cost);
        }

        return dp[x];
    }
}

/** bottom-up 다익스트라 버전 **/
/*
public class Main_김희연 {
    static int n, d;
    static List<Node>[] list;
    static int[] dp;

    private static class Node implements Comparable<Node>{
        int to, cost;

        private Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        list = new List[d+1];
        for(int i=0; i<=d; i++)
            list[i] = new ArrayList<>();

        dp = new int[d+1];
        Arrays.fill(dp, d+1);

        for(int i=0; i<d; i++){
            list[i].add(new Node(i+1, 1));
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b <= d)
                list[a].add(new Node(b, c));
        }

        dijkstra(0);

        System.out.println(dp[d]);
    }

    private static void dijkstra(int num){
        Queue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[d+1];
        dp[num] = 0;

        pq.add(new Node(num, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.to;

            if(visit[now])
                continue;

            visit[now] = true;
            for(Node l : list[now]){
                if(!visit[l.to] && dp[l.to] > (dp[now] + l.cost)){
                    dp[l.to] = dp[now] + l.cost;
                    pq.add(new Node(l.to, dp[l.to]));
                }
            }
        }
    }
}
 */
