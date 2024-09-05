package week10.BOJ_4192_골드2_친구네트워크;

import java.io.*;
import java.util.*;

public class Main_김현창 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] parent = new int[200_100];

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            Map<String, Integer> nameMapper = new HashMap<>();
            int F = Integer.parseInt(br.readLine());
            Arrays.fill(parent, -1);

            while (F-- > 0) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!nameMapper.containsKey(name1))
                    nameMapper.put(name1, nameMapper.size());
                if (!nameMapper.containsKey(name2))
                    nameMapper.put(name2, nameMapper.size());

                int f1 = nameMapper.get(name1);
                int f2 = nameMapper.get(name2);
                sb.append(union(parent, f1, f2))
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

    private static int union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a != b) {
            parent[a] += parent[b];
            parent[b] = a;
        }
        return -parent[a];
    }
}
