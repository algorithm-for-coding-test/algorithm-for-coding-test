package week10.BOJ_18116_골드4_로봇조립;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int MAX_SIZE = 1_000_010;

        int N = Integer.parseInt(br.readLine());

        int[] parent = new int[MAX_SIZE];
        Arrays.fill(parent, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            char q = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = q == 'I' ? Integer.parseInt(st.nextToken()) : -1;
            if (q == 'I') {
                union(parent, a, b);
            } else {
                sb.append(-parent[find(parent, a)])
                        .append("\n");
            }
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int find(int[] parent, int x) {
        if (parent[x] < 0)
            return x;
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a != b) {
            parent[a] += parent[b];
            parent[b] = a;
        }
    }
}
