package week5.BOJ_4889_실버1_안정적인문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int testCase = 1;
		while(!str.contains("-")) {
			
			int resultCnt = 0;
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				
				char ch = str.charAt(i);
				if(ch == '{') {
					
					stack.push(ch);
				}
				else if(ch == '}') {
					
					if(stack.isEmpty()) {
						stack.push('{');
						resultCnt++;
					}
					else {
						
						if(stack.peek() == '{') {
							stack.pop();
						}
					}
				}
			}
			
			resultCnt += stack.size() / 2;
			
			sb.append(testCase).append(". ").append(resultCnt).append("\n");
			
			str = br.readLine();
			testCase++;
		}
		
		System.out.println(sb);
	}
}

