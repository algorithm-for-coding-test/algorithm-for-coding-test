package week8.BOJ_11000_골드5_강의실배정;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Pair[] classes = new Pair[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			classes[i] = new Pair(Integer.parseInt(st.nextToken()),
								  Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(classes, (o1, o2) -> Integer.compare(o1.s, o2.s));
		Queue<Pair> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));

		for (Pair cls: classes) {
			if (heap.size() > 0 && heap.peek().t <= cls.s) {
				heap.poll();
			}
			heap.add(cls);
		}
		System.out.println(heap.size());
	    br.close();
	}

	private static class Pair {
		int s, t;

		Pair(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}
}
