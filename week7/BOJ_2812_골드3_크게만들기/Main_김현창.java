package week7.BOJ_2812_골드3_크게만들기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Character> stack = new ArrayDeque<>();

		String number = br.readLine();
		for (char c: number.toCharArray()) {
			while (K > 0 && !stack.isEmpty() && stack.peek() < c) {
				stack.pop();
				--K;
			}
			stack.push(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		sb.reverse();
		sb.setLength(sb.length() - K);
		System.out.println(sb.toString());
		br.close();
	}
}
