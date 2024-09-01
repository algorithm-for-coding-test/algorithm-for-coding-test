package week9.BOJ_16118_골드1_달빛여우;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) << 1;
            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
        }

        int[] distanceFox = dijkstraFox(graph, N);
        int[] distanceWolf = dijkstraWolf(graph, N);

        int answer = 0;
        for (int i = 1; i <= N; ++i) {
            if (distanceFox[i] < distanceWolf[i])
                ++answer;
        }
        System.out.println(answer);
        br.close();
    }

    private static int[] dijkstraFox(List<List<Node>> graph, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(1, 0));
        distance[1] = 0;
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

    private static int[] dijkstraWolf(List<List<Node>> graph, int n) {
        int[][] distance = new int[n + 1][2];
        for (int i = 0; i <= n; ++i) {
            distance[i][0] = distance[i][1] = INF;
        }
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(1, 0, 1));
        distance[1][1] = 0;
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.index][currNode.run] < currNode.weight)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                int cost = currNode.weight + (currNode.run == 1 ? nextNode.weight >> 1 : nextNode.weight << 1);

                if (distance[nextNode.index][1 - currNode.run] > cost) {
                    distance[nextNode.index][1 - currNode.run] = cost;
                    heap.add(new Node(nextNode.index, cost, 1 - currNode.run));
                }
            }
        }

        int[] _distance = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            _distance[i] = Math.min(distance[i][0], distance[i][1]);
        }
        return _distance;
    }

    private static class Node {
        int index, weight, run;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        Node(int index, int weight, int run) {
            this(index, weight);
            this.run = run;
        }
    }
}
