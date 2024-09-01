package week9.BOJ_1948_플래티넘5_임계경로;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>(n + 1);
        List<List<Node>> revGraph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, t));
            revGraph.get(v).add(new Node(u, t));
            ++inDegree[v];
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] time = topologySort(graph, n, inDegree);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(e);
        boolean[] on = new boolean[n + 1];
        on[e] = true;
        int criticalPath = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Node next: revGraph.get(now)) {
                if (time[now] - time[next.index] == next.time) {
                    ++criticalPath;
                    if (!on[next.index]) {
                        queue.add(next.index);
                        on[next.index] = true;
                    }
                }
            }
        }

        System.out.println(time[e]);
        System.out.println(criticalPath);
        br.close();
    }

    private static int[] topologySort(List<List<Node>> graph, int n, int[] inDegree) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        for (int i = 0; i < n; ++i) {
            assert !queue.isEmpty();
            int now = queue.poll();

            for (Node next: graph.get(now)) {
                time[next.index] = Math.max(time[next.index], time[now] + next.time);
                if (--inDegree[next.index] == 0) {
                    queue.add(next.index);
                }
            }
        }
        return time;
    }

    private static class Node {
        int index, time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
