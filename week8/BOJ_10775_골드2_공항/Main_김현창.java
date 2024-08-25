package week8.BOJ_10775_골드2_공항;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] g = new int[P];
		for (int i = 0; i < P; ++i) {
			g[i] = Integer.parseInt(br.readLine());
		}

		int[] parent = new int[G + 1];
		for (int i = 1; i <= G; ++i) {
			parent[i] = i;
		}

		int answer = 0;
		for (int gi: g) {
			int x = find(parent, gi);
			if (x == 0)
				break;
			++answer;
			union(parent, x, x - 1);
		}
		System.out.println(answer);
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
