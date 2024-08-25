package week8.BOJ_2138_골드4_전구와스위치;

import java.io.*;

public class Main_김현창 {

	private static final int INF = 123456789;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] state = new int[N];
		int[] target = new int[N];

		String line = br.readLine();
		for (int i = 0; i < N; ++i) {
			state[i] = line.charAt(i) - '0';
		}

		line = br.readLine();
		for (int i = 0; i < N; ++i)
			target[i] = line.charAt(i) - '0';

		int first = test(state, target, N);

		click(state, N, 0);
		int second = test(state, target, N);

		int answer = Math.min(first, second + 1);
		System.out.println(answer == INF ? -1 : answer);
	    br.close();
	}

	private static int test(int[] state, int[] target, int n) {
		int[] cloned = state.clone();
		int click = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (cloned[i] != target[i]) {
				++click;
				click(cloned, n, i + 1);
			}
		}

		for (int i = 0; i < n; ++i) {
			if (cloned[i] != target[i])
				return INF;
		}
		return click;
	}

	private static void click(int[] state, int n, int i) {
		state[i] = 1 - state[i];
		if (i > 0)
			state[i - 1] = 1 - state[i - 1];
		if (i < n - 1)
			state[i + 1] = 1 - state[i + 1];
	}
}
