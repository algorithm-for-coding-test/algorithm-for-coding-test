package week9.BOJ_1800_골드1_인터넷설치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_김현창 {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int left = 0;
        int right = 1_000_001;
        boolean possible = false;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (dijkstra(graph, N, K, mid)) {
                right = mid - 1;
                possible = true;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(possible ? right + 1 : -1);
        br.close();
    }

    private static boolean dijkstra(List<List<Node>> graph, int n, int k, int bound) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(1, 0));
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (distance[currNode.index] < currNode.weight)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                int cost = currNode.weight + (nextNode.weight > bound ? 1 : 0);
                if (distance[nextNode.index] > cost) {
                    distance[nextNode.index] = cost;
                    heap.add(new Node(nextNode.index, cost));
                }
            }
        }
        return distance[n] <= k;
    }

    private static class Node {
        int index, weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}

class AnotherSolution {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int left = 0;
        int right = 1_000_001;
        boolean possible = false;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (dijkstra(graph, N, K, mid)) {
                right = mid - 1;
                possible = true;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(possible ? right + 1 : -1);
        br.close();
    }

    private static boolean dijkstra(List<List<Node>> graph, int n, int k, int bound) {
        int[][] distance = new int[n + 1][k + 1];
        for (int i = 0; i <= n; ++i)
            Arrays.fill(distance[i], INF);
        distance[1][0] = 0;
        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        heap.add(new Node(1, 0, 0));
        while (heap.size() > 0) {
            Node currNode = heap.poll();

            if (currNode.index == n)
                return true;

            if (distance[currNode.index][currNode.free] < currNode.weight)
                continue;

            for (Node nextNode: graph.get(currNode.index)) {
                int cost = currNode.weight + nextNode.weight;
                int nFree = currNode.free + (nextNode.weight > bound ? 1 : 0);
                if (k >= nFree && distance[nextNode.index][nFree] > cost) {
                    distance[nextNode.index][nFree] = cost;
                    heap.add(new Node(nextNode.index, nFree, cost));
                }
            }
        }
        return false;
    }

    private static class Node {
        int index, free, weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        Node(int index, int free, int weight) {
            this.index = index;
            this.free = free;
            this.weight = weight;
        }
    }
}
