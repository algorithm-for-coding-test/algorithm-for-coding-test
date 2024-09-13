package week10.BOJ_3830_플래티넘3_교수님은기다리지않는다;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		final int MAX_SIZE = 100_010;

		int[] parent = new int[MAX_SIZE];
		long[] parentValue = new long[MAX_SIZE];

		StringBuilder sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			for (int i = 0; i <= N; ++i) {
				parent[i] = i;
				parentValue[i] = 0;
			}

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = c == '!' ? Integer.parseInt(st.nextToken()) : -1;
				if (c == '!') {
					union(parent, parentValue, a, b, w);
				} else {
					if (find(parent, parentValue, a) == find(parent, parentValue, b)) {
						sb.append(parentValue[b] - parentValue[a]).append("\n");
					} else {
						sb.append("UNKNOWN\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	    br.close();
	}

	private static int find(int[] parent, long[] parentValue, int x) {
		if (parent[x] != x) {
			int p = find(parent, parentValue, parent[x]);
			parentValue[x] = parentValue[x] + parentValue[parent[x]];
			parent[x] = p;
		}
		return parent[x];
	}

	private static void union(int[] parent, long[] parentValue, int a, int b, int w) {
		int rootA = find(parent, parentValue, a);
		int rootB = find(parent, parentValue, b);

		if (rootA != rootB) {
			parent[rootB] = rootA;
			parentValue[rootB] = parentValue[a] - parentValue[b] + w;
		}
	}
}
