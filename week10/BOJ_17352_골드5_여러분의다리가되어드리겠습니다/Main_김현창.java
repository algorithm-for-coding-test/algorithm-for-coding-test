package week10.BOJ_17352_골드5_여러분의다리가되어드리겠습니다;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; ++i)
            parent[i] = i;

        for (int i = 0; i < N - 2; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parent, a, b);
        }

        int root = find(parent, 1);
        for (int i = 2; i <= N; ++i) {
            if (root != find(parent, i)) {
                System.out.println(1 + " " + i);
                break;
            }
        }
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
