package week5.BOJ_23294_골드4_웹브라우저1;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] CAP = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			CAP[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> backward = new ArrayDeque<>();
		Deque<Integer> forward = new ArrayDeque<>();

		int page = 0;
		int backwardCache = 0;
		int forwardCache = 0;

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);

			if (cmd == 'B') {
				if (!backward.isEmpty()) {
					forward.addFirst(page);
					forwardCache += CAP[page];
					backwardCache -= CAP[backward.peekLast()];
					page = backward.removeLast();
				}
			} else if (cmd == 'F') {
				if (!forward.isEmpty()) {
					backward.addLast(page);
					backwardCache += CAP[page];
					forwardCache -= CAP[forward.peekFirst()];
					page = forward.removeFirst();
				}
			} else if (cmd == 'A') {
				int num = Integer.parseInt(st.nextToken());
				forwardCache = 0;
				forward.clear();
				if (page != 0) {
					backward.addLast(page);
					backwardCache += CAP[page];
				}
				page = num;
				while (forwardCache + backwardCache + CAP[page] > C) {
					backwardCache -= CAP[backward.pollFirst()];
				}
			} else if (cmd == 'C') {
				Deque<Integer> temp = new ArrayDeque<>();
				while (!backward.isEmpty()) {
					int x = backward.removeFirst();
					if (temp.isEmpty()) {
						temp.add(x);
					} else {
						if (temp.peekLast() != x) {
							temp.add(x);
						} else {
							backwardCache -= CAP[x];
						}
					}
				}
				backward = temp;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(page).append("\n");
		if (backward.isEmpty())
			sb.append("-1");
		while (!backward.isEmpty()) {
			sb.append(backward.removeLast()).append(" ");
		}
		sb.append("\n");
		if (forward.isEmpty())
			sb.append("-1");
		while (!forward.isEmpty()) {
			sb.append(forward.removeFirst()).append(" ");
		}
		System.out.println(sb.toString());
	    br.close();
	}
}
