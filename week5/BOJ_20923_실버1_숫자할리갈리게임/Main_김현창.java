package week5.BOJ_20923_실버1_숫자할리갈리게임;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final String[] signature = {"do", "su", "dosu"};

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer>[] deck = new Deque[2];
		deck[0] = new ArrayDeque<>(60006);
		deck[1] = new ArrayDeque<>(60006);
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			deck[0].addLast(Integer.parseInt(st.nextToken()));
			deck[1].addLast(Integer.parseInt(st.nextToken()));
		}

		Deque<Integer>[] ground = new Deque[2];
		ground[0] = new ArrayDeque<>();
		ground[1] = new ArrayDeque<>();
		int turn = 0;
		int winner = 2;
		while (M-- > 0) {
			int card = deck[turn].removeLast();
			ground[turn].addLast(card);
			if (deck[turn].isEmpty()) {
				winner = 1 - turn;
				break;
			}

			// 3
			if (!ground[0].isEmpty() && !ground[1].isEmpty() &&
				(ground[0].peekLast() + ground[1].peekLast() == 5)) {
				merge(deck[1], ground[0]);
				merge(deck[1], ground[1]);
			} else if ((!ground[0].isEmpty() && ground[0].peekLast() == 5) ||
					   (!ground[1].isEmpty() && ground[1].peekLast() == 5)) {
				merge(deck[0], ground[1]);
				merge(deck[0], ground[0]);
			}
			turn = 1 - turn;
		}

		if (winner == 2) {
			if (deck[0].size() > deck[1].size())
				winner = 0;
			else if (deck[0].size() < deck[1].size())
				winner = 1;
		}
		System.out.println(signature[winner]);
	    br.close();
	}

	private static void merge(Deque<Integer> deck, Deque<Integer> ground) {
		while (!ground.isEmpty())
			deck.addFirst(ground.pollFirst());
	}
}
