package week5.BOJ_2841_실버1_외계인의기타연주;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		Deque<Integer>[] guitar = new Deque[7];
		for (int i = 1; i < 7; ++i) {
			guitar[i] = new ArrayDeque<>();
		}

		int answer = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int flet = Integer.parseInt(st.nextToken());
			while (!guitar[line].isEmpty() && guitar[line].peekLast() > flet) {
				guitar[line].pollLast();
				++answer;
			}
			if (guitar[line].isEmpty() || guitar[line].peekLast() < flet) {
				guitar[line].addLast(flet);
				++answer;
			}
		}
		System.out.println(answer);
		br.close();
	}
}
