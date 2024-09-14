package week10.BOJ_1197_골드4_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {

    static int[] parent;

    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node (int to, int from, int value){
            this.to = to;
            this.from = from;
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

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        int size = pq.size();
        int total = 0;
        for(int i=0; i<size; i++){
            Node node = pq.poll();

            if(find(node.to) != find(node.from)){
                total += node.value;
                union(node.to, node.from);
            }
        }
        System.out.println(total);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}
