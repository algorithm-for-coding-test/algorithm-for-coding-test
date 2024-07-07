package week5.BOJ_11286_실버1_절대값힙;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 == abs2)
				return Integer.compare(o1, o2);
			return abs1 < abs2 ? -1 : 1;
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				Integer poll = heap.poll();
				sb.append(poll == null ? 0 : poll).append("\n");
			} else {
				heap.add(x);
			}
		}
		System.out.println(sb.toString());
	    br.close();
	}
}
