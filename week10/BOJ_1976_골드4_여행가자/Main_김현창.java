package week10.BOJ_1976_골드4_여행가자;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; ++i)
            parent[i] = i;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 1) {
                    union(parent, i + 1, j + 1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean possible = true;
        for (int i = 0; i < M - 1; ++i) {
            int other = Integer.parseInt(st.nextToken());
            if (find(parent, first) != find(parent, other)) {
                possible = false;
                break;
            }
        }
        System.out.println(possible ? "YES" : "NO");
        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}
