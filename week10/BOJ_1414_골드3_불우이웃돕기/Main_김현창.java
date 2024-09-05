package week10.BOJ_1414_골드3_불우이웃돕기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;

        List<Edge> edges = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                char c = line.charAt(j);
                if (c == '0')
                    continue;
                int length = convert(c);
                edges.add(new Edge(i, j, length));
                answer += length;
            }
        }

        edges.sort((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        int call = 0;
        for (Edge edge: edges) {
            if (find(parent, edge.a) == find(parent, edge.b))
                continue;
            union(parent, edge.a, edge.b);
            answer -= edge.cost;
            ++call;
        }
        System.out.println(call == N - 1 ? answer : -1);
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

    private static int convert(char c) {
        if ('a' <= c && c <= 'z')
            return c - 'a' + 1;
        if ('A' <= c && c <= 'Z')
            return c - 'A' + 27;
        return -1;
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
