package week10.BOJ_2887_플래티넘5_행성터널;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			Point point = new Point();
			point.num = i;
			point.x = Integer.parseInt(st.nextToken());
			point.y = Integer.parseInt(st.nextToken());
			point.z = Integer.parseInt(st.nextToken());
			points[i] = point;
		}

		List<Edge> edges = new ArrayList<>();

		Arrays.sort(points, (o1, o2) -> Integer.compare(o1.x, o2.x));
		for (int i = 0; i < N - 1; ++i) {
			Edge edge = new Edge();
			edge.a = points[i].num;
			edge.b = points[i + 1].num;
			edge.cost = Math.abs(points[i].x - points[i + 1].x);
			edges.add(edge);
		}

		Arrays.sort(points, (o1, o2) -> Integer.compare(o1.y, o2.y));
		for (int i = 0; i < N - 1; ++i) {
			Edge edge = new Edge();
			edge.a = points[i].num;
			edge.b = points[i + 1].num;
			edge.cost = Math.abs(points[i].y - points[i + 1].y);
			edges.add(edge);
		}

		Arrays.sort(points, (o1, o2) -> Integer.compare(o1.z, o2.z));
		for (int i = 0; i < N - 1; ++i) {
			Edge edge = new Edge();
			edge.a = points[i].num;
			edge.b = points[i + 1].num;
			edge.cost = Math.abs(points[i].z - points[i + 1].z);
			edges.add(edge);
		}

		System.out.println(kruskal(edges, edges.size()));
	    br.close();
	}

	private static long kruskal(List<Edge> edges, int n) {
		int[] parent = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
		}

		edges.sort((o1, o2) -> Integer.compare(o1.cost, o2.cost));

		long answer = 0;
		for (Edge edge: edges) {
			if (find(parent, edge.a) == find(parent, edge.b))
				continue;
			union(parent, edge.a, edge.b);
			answer += edge.cost;
		}
		return answer;
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
		else parent[a] = b;
	}

	private static class Edge {
		int a, b, cost;
	}

	private static class Point {
		int num, x, y, z;
	}
}
