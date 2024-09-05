package week10.BOJ_1197_골드4_최소스패닝트리;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] parent = new int[V + 1];
        for (int i = 1; i <= V; ++i)
            parent[i] = i;

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            Edge edge = new Edge();
            edge.a = Integer.parseInt(st.nextToken());
            edge.b = Integer.parseInt(st.nextToken());
            edge.cost = Integer.parseInt(st.nextToken());
            edges[i] = edge;
        }
        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        long answer = 0;
        for (Edge edge: edges) {
            if (find(parent, edge.a) == find(parent, edge.b))
                continue;
            union(parent, edge.a, edge.b);
            answer += edge.cost;
        }
        System.out.println(answer);
        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b)
            parent[b] = a;
        else parent[a] = b;
    }

    private static class Edge {
        int a, b, cost;
    }
}
