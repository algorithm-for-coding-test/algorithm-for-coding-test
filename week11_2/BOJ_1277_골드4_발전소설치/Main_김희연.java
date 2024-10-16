package week11_2.BOJ_1277_골드4_발전소설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_김희연 {
	static double INF = Double.MAX_VALUE;
	static int n, w;
	static double m;
	static Point[] plant;
	static List<Node>[] list;
	static double[] dist;

	static class Node implements Comparable<Node>{
		int to;
		double value;

		public Node(int to, double value){
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o){
			return Double.compare(this.value, o.value);
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		m = Double.parseDouble(br.readLine());

		list = new ArrayList[n+1];
		dist = new double[n+1];
		plant = new Point[n+1];

		Arrays.fill(dist, INF);

		for(int i=1; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			plant[i] = new Point(a, b);
		}

		for(int i=0; i<w; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			//추가 전선 길이 구하므로 기존에 연결된 전선 길이는 0으로 설정
			list[a].add(new Node(b, 0));
			list[b].add(new Node(a, 0));
		}

		// 가능한 모든 발전소 간의 거리 계산 및 연결
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				double c = getDistance(i, j);
				if (c <= m) {
					list[i].add(new Node(j, c));
					list[j].add(new Node(i, c));
				}
			}
		}

		dijkstra(1);

		System.out.println((int)Math.floor(dist[n] * 1000));
	}

	public static void dijkstra(int from){
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[n+1];
		pq.add(new Node(from, 0));
		dist[from] = 0;

		while(!pq.isEmpty()){
			Node node = pq.poll();
			int to = node.to;

			if(visit[to])
				continue;
			visit[to] = true;

			for(Node n : list[to]){
				if(dist[n.to] > dist[to] + n.value){
					dist[n.to] = dist[to] + n.value;
					pq.add(new Node(n.to, dist[n.to]));
				}
			}
		}
	}

	public static double getDistance(int a, int b){
		Point point1 = plant[a];
		Point point2 = plant[b];
		return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
	}
}
