package week11_2.BOJ_1277_골드4_발전소설치;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		double M = Double.parseDouble(br.readLine());

		int[] X = new int[N + 1];
		int[] Y = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}

		List<List<Node>> graph = new ArrayList<>(N + 1);
		for (int i = 0; i <= N; ++i)
			graph.add(new ArrayList<>());

		for (int i = 1; i <= N; ++i) {
			for (int j = i + 1; j <= N; ++j) {
				double distance = getDistance(X[i], Y[i], X[j], Y[j]);
				if (distance <= M) {
					graph.get(i).add(new Node(j, distance));
					graph.get(j).add(new Node(i, distance));
				}
			}
		}

		for (int i = 0; i < W; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, 0));
			graph.get(b).add(new Node(a, 0));
		}

		System.out.println((int) (dijkstra(graph, N) * 1000));
		br.close();
	}

	private static double dijkstra(List<List<Node>> graph, int n) {
		double[] distance = new double[n + 1];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[1] = 0;
		Queue<Node> heap = new PriorityQueue<>((o1, o2) -> Double.compare(o1.weight, o2.weight));
		heap.add(new Node(1, 0));
		while (heap.size() > 0) {
			Node currNode = heap.poll();

			if (distance[currNode.index] < currNode.weight)
				continue;

			for (Node nextNode: graph.get(currNode.index)) {
				double cost = currNode.weight + nextNode.weight;
				if (distance[nextNode.index] > cost) {
					distance[nextNode.index] = cost;
					heap.add(new Node(nextNode.index, cost));
				}
			}
		}
		return distance[n];
	}

	private static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	private static class Node {
		int index;
		double weight;

		Node(int index, double weight) {
			this.index = index;
			this.weight = weight;
		}
	}
}
