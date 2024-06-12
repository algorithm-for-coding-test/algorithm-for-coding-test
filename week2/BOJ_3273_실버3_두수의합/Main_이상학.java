package week2.BOJ_3273_실버3_두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nList = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nList[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(nList);
		int result = 0;
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			
			int sum = nList[start] + nList[end];
			if(sum < x) {
				start++;
			}
			else if(sum == x) {
				result++;
				start++;
				end--;
			}
			else if(sum > x) {
				end--;
			}
		}

		System.out.println(result);
	}
}
