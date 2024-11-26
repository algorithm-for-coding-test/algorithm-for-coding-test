package week14_2.BOJ_2257_실버2_화학식량;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static final Map<Character, Integer> map;

	static {
		map = new HashMap<>();
		map.put('H', 1);
		map.put('C', 12);
		map.put('O', 16);
	}

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> stack = new ArrayDeque<>();
		char[] expr = br.readLine().toCharArray();
		for (char c: expr) {
			if (c == '(') {
				stack.push(-1);
			} else if (c == ')') {
				int x = 0;
				while (!stack.isEmpty() && stack.peek() != -1) {
					x += stack.pop();
				}
				stack.pop();
				stack.push(x);
			} else if (c == 'H' || c == 'C' || c == 'O') {
				stack.push(map.get(c));
			} else {
				int cnt = c - '0';
				stack.push(stack.pop() * cnt);
			}
		}

		int answer = 0;
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
		br.close();
	}
}
