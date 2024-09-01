package week9.BOJ_5719_플래티넘5_거의최단경로;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static int S, D;
    private static List<List<Node>> graph;
    private static List<List<Node>> revGraph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (input(br)) {
            sb.append(solve()).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static int solve() {
        int[] distance = dijkstra(S, null);
        boolean[][] removed = new boolean[N][N];
        boolean[] on = new boolean[N];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(D);
        on[D] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node nextNode: revGraph.get(now)) {
                if (distance[now] - distance[nextNode.index] == nextNode.weight) {
                    removed[nextNode.index][now] = true;
                    removed[now][nextNode.index] = true;
                    if (!on[nextNode.index]) {
                        queue.add(nextNode.index);
                        on[nextNode.index] = true;
                    }
                }
            }
        }
        int res = dijkstra(S, removed)[D];
        return res == INF ? -1 : res;
    }

    private static int[] dijkstra(int start, boolean[][] removedEdges) {
        int[] distance = new int[N];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(start, 0));
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.index] < currNode.weight)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                if (removedEdges != null && removedEdges[currNode.index][nextNode.index])
                    continue;

                int cost = currNode.weight + nextNode.weight;
                if (distance[nextNode.index] > cost) {
                    distance[nextNode.index] = cost;
                    heap.add(new Node(nextNode.index, cost));
                }
            }
        }
        return distance;
    }

    private static boolean input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0 && M == 0)
            return false;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        revGraph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            graph.get(U).add(new Node(V, P));
            revGraph.get(V).add(new Node(U, P));
        }
        return true;
    }

    private static class Node {
        int index, weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
