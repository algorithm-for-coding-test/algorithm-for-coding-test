package week5.BOJ_1406_실버2_에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_김희연 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> LStack = new Stack<>();
		Stack<Character> RStack = new Stack<>();

		String str = br.readLine();
		char arr[] = str.toCharArray();

		for(int i=0; i<arr.length; i++)
			LStack.push(arr[i]);

		int M = Integer.parseInt(br.readLine());

		for(int i=0; i<M; i++) {
			str = br.readLine();
			arr = str.toCharArray();

			switch(arr[0]){
				case 'L' :
					if(LStack.empty())
						break;
					RStack.push(LStack.pop());
					break;
				case 'D' :
					if(RStack.empty())
						break;
					LStack.push(RStack.pop());
					break;
				case 'B' :
					if(LStack.empty())
						break;
					LStack.pop();
					break;
				case 'P' :
					LStack.push(arr[2]);
			}
		}

		while(!LStack.empty())
			RStack.push(LStack.pop());

		while(!RStack.empty())
			sb.append(RStack.pop());

		System.out.println(sb);
	}
}
