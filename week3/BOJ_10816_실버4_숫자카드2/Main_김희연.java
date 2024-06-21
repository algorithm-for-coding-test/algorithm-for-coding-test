package week3.BOJ_10816_실버4_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			int key = Integer.parseInt(st.nextToken());

			int lower = lowerBound(arr, key);
			int upper = upperBound(arr, key);

			sb.append(upper-lower).append(" ");
		}

		System.out.println(sb);
	}

	public static int lowerBound(int[] arr, int key){
		int start = 0;
		int end = arr.length;

		while(start < end){
			int mid = (start + end) / 2;

			if(key <= arr[mid]){
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	private static int upperBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;

		while (start < end) {
			int mid = (start + end) / 2;

			if (key < arr[mid]) {
				end = mid;
			} else {
				start = mid + 1;
			}

		}

		return start;
	}
}
