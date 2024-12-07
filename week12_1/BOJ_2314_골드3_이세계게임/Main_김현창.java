package week12_1.BOJ_2314_골드3_이세계게임;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final int[][] exchange = {
		{0, 1}, {1, 2}, {2, 3},
		{4, 5}, {5, 6}, {6, 7},
		{8, 9}, {9, 10}, {10, 11},
		{12, 13}, {13, 14}, {14, 15},
		{0, 4}, {4, 8}, {8, 12},
		{1, 5}, {5, 9}, {9, 13},
		{2, 6}, {6, 10}, {10, 14},
		{3, 7}, {7, 11}, {11, 15}
	};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int start = 0;
		for (int i = 0; i < 4; ++i) {
			String line = br.readLine();
			for (int j = 0; j < 4; ++j) {
				if (line.charAt(j) == 'P')
					start |= 1 << (i * 4 + j);
			}
		}

		br.readLine();

		int target = 0;
		for (int i = 0; i < 4; ++i) {
			String line = br.readLine();
			for (int j = 0; j < 4; ++j) {
				if (line.charAt(j) == 'P')
					target |= 1 << (i * 4 + j);
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		int[] visited = new int[1 << 16];
		queue.add(start);
		visited[start] = 1;
		int answer = -1;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == target) {
				answer = visited[now] - 1;
				break;
			}

			for (int[] idx: exchange) {
				int next = now;
				int x = next & (1 << idx[0]);
				int y = next & (1 << idx[1]);
				next &= ~(1 << idx[0]);
				next &= ~(1 << idx[1]);
				if (x > 0)
					next |= (1 << idx[1]);
				if (y > 0)
					next |= (1 << idx[0]);

				if (visited[next] != 0)
					continue;
				visited[next] = visited[now] + 1;
				queue.add(next);
			}
		}
		System.out.println(answer);
	    br.close();
	}
}
