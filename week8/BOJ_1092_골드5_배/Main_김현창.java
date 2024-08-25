package week8.BOJ_1092_골드5_배;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] cranes = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		List<Integer> boxes = new ArrayList<>(M);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		br.close();

		Arrays.sort(cranes);
		boxes.sort((o1, o2) -> Integer.compare(o1, o2));

		if (boxes.get(M - 1) > cranes[N - 1]) {
			System.out.println(-1);
			return;
		}

		int answer = 0;
		while (boxes.size() > 0) {
			++answer;
			for (int wl: cranes) {
				for (int i = boxes.size() - 1; i >= 0; --i) {
					if (wl >= boxes.get(i)) {
						boxes.remove(i);
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
