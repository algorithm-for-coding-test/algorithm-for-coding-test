package week5.BOJ_18115_실버3_카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		String str = new StringBuilder(br.readLine()).reverse().toString();
		st = new StringTokenizer(str);

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 1) {
				deque.addFirst(i);
			} else if (num == 2) {
				int top = deque.removeFirst();
				deque.addFirst(i);
				deque.addFirst(top);
			} else {
				deque.addLast(i);
			}
		}

		for(int x : deque)
			sb.append(deque.removeFirst() + " ");

		System.out.println(sb);
	}
}