package week9.BOJ_1753_골드4_최단경로;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int INF = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; ++i) {
            graph.add(new ArrayList<>());
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        heap.add(new Node(K, 0));
        int[] distance = new int[V + 1];
        Arrays.fill(distance, INF);
        distance[K] = 0;
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.index] < currNode.cost)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                int cost = currNode.cost + nextNode.cost;
                if (distance[nextNode.index] > cost) {
                    distance[nextNode.index] = cost;
                    heap.add(new Node(nextNode.index, cost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; ++i) {
            if (distance[i] == INF)
                sb.append("INF\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    private static class Node {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
