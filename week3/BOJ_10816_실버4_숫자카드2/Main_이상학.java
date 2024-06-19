package week3.BOJ_10816_실버4_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {

	// 이분탐색을 통한 풀이
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {

			int target = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = arr.length - 1;
			while(left <= right) {
				
				int mid = (left + right) / 2;
				if(arr[mid] >= target) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			
			int lowerIdx = left;
			
			left = 0;
			right = arr.length - 1;
			while(left <= right) {
				
				int mid = (left + right) / 2;
				if(arr[mid] > target) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			
			int upperIdx = right;
			
			sb.append(upperIdx - lowerIdx + 1).append(" ");
		}
		
		System.out.println(sb);
	}
	
	// HashMap을 통한 풀이
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st;
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		Map<Integer, Integer> map = new HashMap<>();
//		st = new StringTokenizer(br.readLine());
//		int num = 0;
//		for(int i=0; i<N; i++) {
//			
//			num = Integer.parseInt(st.nextToken());
//			if(map.get(num) == null) {
//				map.put(num, 1);
//			}
//			else {
//				map.put(num, map.get(num)+1);
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		int M = Integer.parseInt(br.readLine());
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<M; i++) {
//			
//			num = Integer.parseInt(st.nextToken());
//			sb.append(map.get(num) != null ? map.get(num) : 0).append(" ");
//		}
//		
//		System.out.println(sb);
//	}
}
