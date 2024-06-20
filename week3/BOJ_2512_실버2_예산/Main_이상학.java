package week3.BOJ_2512_실버2_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		int left = 0;
		int right = arr[arr.length-1];
		while(left <= right) {
			
			int mid = (left + right) / 2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] > mid) {
					sum += mid;
				}
				else {
					sum += arr[i];
				}
			}
			
			if(sum > M) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(right);
	}
}