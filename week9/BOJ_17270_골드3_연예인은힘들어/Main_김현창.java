package week9.BOJ_17270_골드3_연예인은힘들어;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final int INF = 1234567890;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; ++i)
            graph.add(new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] distanceJ = dijkstra(graph, V, J);
        int[] distanceS = dijkstra(graph, V, S);

        int minDistance = INF;
        List<Integer> indices = new ArrayList<>();  // 2
        for (int i = 1; i <= V; ++i) {
            if (i == J || i == S)   // 1
                continue;
            int sum = distanceJ[i] + distanceS[i];
            if (minDistance > sum) {
                minDistance = sum;
                indices = new ArrayList<>();
                indices.add(i);
            } else if (minDistance == sum) {
                indices.add(i);
            }
        }

        int jj = INF;
        int jIndex = -1;
        for (int i: indices) {
            if (distanceS[i] < distanceJ[i])
                continue;
            if (jj > distanceJ[i]) {
                jj = distanceJ[i];
                jIndex = i;
            }
        }
        System.out.println(jIndex);
        br.close();
    }

    private static int[] dijkstra(List<List<Node>> graph, int n, int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(start, 0));
        distance[start] = 0;
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.index] < currNode.weight)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                int cost = currNode.weight + nextNode.weight;

                if (distance[nextNode.index] > cost) {
                    distance[nextNode.index] = cost;
                    heap.add(new Node(nextNode.index, cost));
                }
            }
        }
        return distance;
    }

    private static class Node {
        int index, weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}