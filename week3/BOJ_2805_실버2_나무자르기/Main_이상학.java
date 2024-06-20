package week3.BOJ_2805_실버2_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(arr);
		int left = 0;
		int right = arr[arr.length-1];
		while(left <= right) {
			
			int mid = (left + right) / 2;
			
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			if(sum >= M) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}
}
