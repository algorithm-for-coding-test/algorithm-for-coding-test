package week14_1.BOJ_16397_골드4_탈출;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		int[] visited = new int[101010];
		Queue<Integer> queue = new ArrayDeque<>();
		visited[N] = 1;
		queue.add(N);

		while (T > 0 && !queue.isEmpty()) {
			int queueSize = queue.size();
			for (int q = 0; q < queueSize; ++q) {
				int now = queue.poll();

				for (int next: new int[] {buttonOne(now), buttonTwo(now)}) {
					if (next == -1)
						continue;
					if (visited[next] > 0)
						continue;
					visited[next] = visited[now] + 1;
					queue.add(next);
				}
			}
			--T;
		}
		System.out.println(visited[G] == 0 ? "ANG" : visited[G] - 1);
	    br.close();
	}

	private static int buttonOne(int n) {
		if (n >= 99999)
			return -1;
		return n + 1;
	}

	private static int buttonTwo(int n) {
		int nn = n * 2;
		if (nn > 99999)
			return -1;
		int mm = (int) Math.pow(10, String.valueOf(nn).length() - 1);
		return nn - mm;
	}
}
