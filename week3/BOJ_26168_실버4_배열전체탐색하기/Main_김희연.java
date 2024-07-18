package week3.BOJ_26168_실버4_배열전체탐색하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());

			if(a == 1){
				long b = Long.parseLong(st.nextToken());
				sb.append(n - lowerBound(arr, b)).append("\n");
			} else if(a == 2){
				long b = Long.parseLong(st.nextToken());
				sb.append(n - upperBound(arr, b)).append("\n");
			} else {
				long b = Long.parseLong(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				sb.append(upperBound(arr, c) - lowerBound(arr, b)).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static int lowerBound(long[] arr, long k){
		int start = 0;
		int end = arr.length;

		while(start < end){
			int mid = (start + end) / 2;

			if(arr[mid] < k){
				start = mid + 1;
			} else
				end = mid;
		}

		return start;
	}

	public static int upperBound(long[] arr, long k){
		int start = 0;
		int end = arr.length;

		while(start < end){
			int mid = (start + end) / 2;

			if(arr[mid] <= k){
				start = mid + 1;
			} else
				end = mid;
		}

		return start;
	}
}
