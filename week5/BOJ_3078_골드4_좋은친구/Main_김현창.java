package week5.BOJ_3078_골드4_좋은친구;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] names = new String[N];
		for (int i = 0; i < N; ++i) {
			names[i] = br.readLine();
		}

		Queue<String> queue = new ArrayDeque<>(K);
		long answer = 0;
		int[] counter = new int[21];
		for (int i = 0; i < N; ++i) {
			String name = names[i];
			queue.add(name);
			answer += counter[name.length()];
			++counter[name.length()];
			if (queue.size() > K)
				--counter[queue.remove().length()];
		}
		System.out.println(answer);
	    br.close();
	}
}
