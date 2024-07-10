package week5.BOJ_4889_실버1_안정적인문자열;

import java.io.*;
import java.util.*;

public class Main_김희연 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = 1;
		while(true) {
			String str = br.readLine();
			if(str.charAt(0) == '-')
				break;

			int n = str.length();
			int cnt = 0;

			Stack<Character> stack = new Stack<>();

			for(int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if(tmp == '{') {
					stack.add(tmp);
				}else {
					if(stack.isEmpty()) {
						// '{'로 변경
						cnt++;
						stack.add('{');
					}
					else
						stack.pop();
				}
			}

			sb.append(num++).append(". ").append(cnt + stack.size()/2).append("\n");
		}
		System.out.println(sb);
	}
}


