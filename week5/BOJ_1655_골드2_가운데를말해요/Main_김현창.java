package week5.BOJ_1655_골드2_가운데를말해요;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> leftHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		Queue<Integer> rightHeap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			int x = Integer.parseInt(br.readLine());
			if (leftHeap.size() == rightHeap.size()) {
				if (leftHeap.isEmpty() || rightHeap.peek() > x) {
					leftHeap.add(x);
				} else {
					leftHeap.add(rightHeap.poll());
					rightHeap.add(x);
				}
			} else {
				if (leftHeap.peek() < x) {
					rightHeap.add(x);
				} else {
					rightHeap.add(leftHeap.poll());
					leftHeap.add(x);
				}
			}
			sb.append(leftHeap.peek()).append("\n");
		}
		System.out.println(sb.toString());
	    br.close();
	}
}
