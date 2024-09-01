package week9.BOJ_20119_골드1_클레어와물약;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i)
            graph.add(new ArrayList<>());

        int[] inDegree = new int[M];
        int[] r = new int[M];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            inDegree[i] = k;
            while (k-- > 0) {
                int x = Integer.parseInt(st.nextToken());
                graph.get(x).add(i);
            }
            r[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] hasPotion = new boolean[N + 1];
        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < L; ++i) {
            int y = Integer.parseInt(st.nextToken());
            queue.add(y);
            hasPotion[y] = true;
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next: graph.get(now)) {
                if (hasPotion[r[next]])
                    continue;
                if (--inDegree[next] == 0) {
                    hasPotion[r[next]] = true;
                    queue.add(r[next]);
                }
            }
        }

        int potionCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i) {
            if (hasPotion[i]) {
                ++potionCount;
                sb.append(i).append(" ");
            }
        }
        System.out.println(potionCount);
        System.out.println(sb.toString());
        br.close();
    }
}
