package week10.BOJ_2458_골드4_키순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int INF = 123456789;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; ++i)
            Arrays.fill(graph[i], INF);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }

        for (int i = 1; i <= N; ++i)
            graph[i][i] = 0;

        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        int[] counter = new int[N + 1];
        for (int k = 1; k <= N; ++k) {
            for (int i = 1; i <= N; ++i) {
                if (graph[i][k] == 1 || graph[k][i] == 1) {
                    counter[i]++;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; ++i) {
            if (counter[i] == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
