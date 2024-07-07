package week5.BOJ_1202_골드2_보석도둑;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewel[] jewels = new Jewel[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}
		int[] bags = new int[K];
		for (int i = 0; i < K; ++i) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bags);
		Arrays.sort(jewels, (o1, o2) -> Integer.compare(o1.m, o2.m));

		Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		int jIndex = 0;
		long answer = 0;
		for (int bag: bags) {
			while (jIndex < N && jewels[jIndex].m <= bag) {
				heap.add(jewels[jIndex].v);
				++jIndex;
			}
			if (!heap.isEmpty()) {
				answer += heap.poll();
			}
		}
		System.out.println(answer);
		br.close();
	}

	private static class Jewel {
		int m, v;

		Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
