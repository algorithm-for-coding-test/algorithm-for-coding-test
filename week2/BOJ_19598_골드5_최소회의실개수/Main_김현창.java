package week2.BOJ_19598_골드5_최소회의실개수;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Pair[] meetings = new Pair[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meetings[i] = new Pair(s, e);
		}

		coordinateCompression(meetings);
		int[] schedule = new int[222222];
		for (Pair meeting: meetings) {
			schedule[meeting.s] += 1;
			schedule[meeting.e] -= 1;
		}

		for (int i = 0; i < 222221; ++i) {
			schedule[i + 1] += schedule[i];
		}

		int answer = 0;
		for (int i = 0; i < 222222; ++i) {
			answer = Math.max(answer, schedule[i]);
		}
		System.out.println(answer);
	    br.close();
	}

	private static void coordinateCompression(Pair[] pairs) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Pair p: pairs) {
			map.put(p.s, 0);
			map.put(p.e, 0);
		}

		int[] sorted = new int[map.size()];
		int idx = 0;
		for (int key: map.keySet()) {
			sorted[idx++] = key;
		}
		Arrays.sort(sorted);

		idx = 0;
		for (int x: sorted) {
			map.put(x, idx++);
		}

		for (Pair p: pairs) {
			p.s = map.get(p.s);
			p.e = map.get(p.e);
		}
	}

	private static class Pair {
		int s, e;

		Pair(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
