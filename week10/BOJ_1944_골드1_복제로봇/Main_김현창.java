package week10.BOJ_1944_골드1_복제로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_김현창 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        List<Pair> pos = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < N; ++j) {
                if (line.charAt(j) == 'S' || line.charAt(j) == 'K')
                    pos.add(new Pair(i, j));
                else if (line.charAt(j) == '1')
                    graph[i][j] = 1;
            }
        }

        int sz = pos.size();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < sz; ++i) {
            fillEdgeUsingBfs(graph, N, pos, i, edges);
        }

        int[] parent = new int[sz];
        for (int i = 0; i < sz; ++i)
            parent[i] = i;

        edges.sort((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        int answer = 0;
        int link = 0;
        for (Edge edge: edges) {
            if (find(parent, edge.a) == find(parent, edge.b))
                continue;
            union(parent, edge.a, edge.b);
            answer += edge.cost;
            ++link;
        }
        System.out.println(link == sz - 1 ? answer : -1);
        br.close();
    }

    private static void fillEdgeUsingBfs(int[][] graph, int n, List<Pair> pos, int index, List<Edge> edges) {
        int x = pos.get(index).x;
        int y = pos.get(index).y;
        Queue<Pair> queue = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        queue.add(new Pair(x, y));
        visited[x][y] = 1;
        while (queue.size() > 0) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (graph[nx][ny] == 1)
                    continue;
                if (visited[nx][ny] > 0)
                    continue;
                queue.add(new Pair(nx, ny));
                visited[nx][ny] = visited[p.x][p.y] + 1;
            }
        }

        for (int i = 0, sz = pos.size(); i < sz; ++i) {
            Pair p = pos.get(i);
            if (i == index)
                continue;
            if (visited[p.x][p.y] == 0)
                continue;
            edges.add(new Edge(index, i, visited[p.x][p.y] - 1));
        }
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

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
