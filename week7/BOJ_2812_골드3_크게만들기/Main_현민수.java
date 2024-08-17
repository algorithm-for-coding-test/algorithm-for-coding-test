package week7.BOJ_2812_골드3_크게만들기;

import java.io.*;
import java.util.*;

public class Main_현민수 {
    
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int N = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());
	        String[] s = br.readLine().split("");

	        Stack<Integer> stack = new Stack<>();
	        int remove = K;

	        for (int i = 0; i < N; i++) {
	            int current = Integer.parseInt(s[i]);
	            while (!stack.isEmpty() && stack.peek() < current && remove > 0) {
	                stack.pop(); 
	                remove--; 
	            }
	            stack.push(current); 
	        }
	        
	        while (!stack.isEmpty() && remove > 0) {
	            stack.pop();
	            remove--;
	        }

	        while (!stack.isEmpty()) {
	            sb.append(stack.pop());
	        }
	        
	        System.out.println(sb.reverse().toString());
	    }
}
