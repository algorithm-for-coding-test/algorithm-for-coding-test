package week9.BOJ_14907_골드2_프로젝트스케줄링;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<List<Integer>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; ++i)
            graph.add(new ArrayList<>());

        int[] time = new int[26];
        int[] inDegree = new int[26];
        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int x = st.nextToken().charAt(0) - 'A';
            time[x] = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
                for (char c: st.nextToken().toCharArray()) {
                    graph.get(c - 'A').add(x);
                    ++inDegree[x];
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[26];
        for (int i = 0; i < 26; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = time[i];
            }
        }

        for (int i = 0; i < 26; ++i) {
            assert queue.size() > 0;
            int now = queue.poll();
            for (int next: graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                if (--inDegree[next] == 0)
                    queue.add(next);
            }
        }
        System.out.println(max(result, 26));
        br.close();
    }

    private static int max(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i)
            max = Math.max(max, arr[i]);
        return max;
    }
}
