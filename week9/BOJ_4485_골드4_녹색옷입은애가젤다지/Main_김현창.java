package week9.BOJ_4485_골드4_녹색옷입은애가젤다지;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[][] graph = new int[125][125];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;

            for (int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(++tc)
                    .append(": ").append(dijkstra(graph, N))
                    .append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static final int INF = Integer.MAX_VALUE;

    private static int dijkstra(int[][] graph, int n) {
        int[][] distance = new int[n][n];
        fill2D(distance, INF);
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(0, 0, graph[0][0]));
        distance[0][0] = graph[0][0];
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.x][currNode.y] < currNode.weight)
                continue;

            for (int i = 0; i < 4; ++i) {
                int nx = currNode.x + dx[i];
                int ny = currNode.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                int cost = currNode.weight + graph[nx][ny];
                if (distance[nx][ny] > cost) {
                    distance[nx][ny] = cost;
                    heap.add(new Node(nx, ny, cost));
                }
            }
        }
        return distance[n - 1][n - 1];
    }

    private static void fill2D(int[][] arr, int val) {
        for (int[] row: arr) {
            Arrays.fill(row, val);
        }
    }

    private static class Node {
        int x, y, weight;

        Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
