package week9.BOJ_14567_골드5_선수과목;

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

        int[] inDegree = new int[N + 1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            ++inDegree[B];
        }

        int[] result = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = 1;
            }
        }

        for (int i = 0; i < N; ++i) {
            assert !queue.isEmpty();
            int now = queue.poll();

            for (int next: graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + 1);
                if (--inDegree[next] == 0)
                    queue.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; ++i)
            sb.append(result[i]).append(" ");
        System.out.println(sb.toString());
        br.close();
    }
}
