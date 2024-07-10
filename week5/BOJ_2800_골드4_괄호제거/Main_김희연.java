package week5.BOJ_2800_골드4_괄호제거;

import java.io.*;
import java.util.*;

public class Main_김희연 {
	static List<int[]> list = new ArrayList<>(); //괄호 짝끼리 담는 리스트
	static Set<String> result;
	static boolean[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		visit = new boolean[str.length()];
		result = new TreeSet<>();
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stack.push(i);
			} else if(c == ')'){
				list.add(new int[] {stack.pop(), i}); // 괄호 인덱스 저장
			}
		}

		comb(0, str.toCharArray());

		for (String s : result) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}

	static void comb(int depth, char[] str) {
		if(depth == list.size()) {
			boolean flag = false;
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<str.length; i++) {
				if(!visit[i]) {
					sb.append(str[i]);
				} else flag = true;
			}
			if(flag) {
				result.add(sb.toString());
			}
			return;
		}

		comb(depth+1, str);

		int[] bracket = list.get(depth);
		visit[bracket[0]] = true;
		visit[bracket[1]] = true;
		comb(depth+1, str);
		visit[bracket[0]] = false;
		visit[bracket[1]] = false;
	}
}