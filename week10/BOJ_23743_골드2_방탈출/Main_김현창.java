package week10.BOJ_23743_골드2_방탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            parent[i] = i;

        Edge[] edges = new Edge[M + N];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()));
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            edges[M + i] = new Edge(0,
                                    i + 1,
                                    Integer.parseInt(st.nextToken()));
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

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
