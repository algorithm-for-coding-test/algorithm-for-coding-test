package week3.BOJ_26168_실버4_배열전체탐색하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] A = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		for(int loop=0; loop<m; loop++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());
			
			if(query == 1) {
				long k = Long.parseLong(st.nextToken());
				sb.append(A.length - getLowerIdx(k, A)).append("\n");
			}
			else if(query == 2) {
				long k = Long.parseLong(st.nextToken());
				sb.append(A.length - 1 - getUpperIdx(k, A)).append("\n");
			}
			else if(query == 3) {
				long i = Long.parseLong(st.nextToken());
				long j = Long.parseLong(st.nextToken());
				sb.append(getUpperIdx(j, A) - getLowerIdx(i, A) + 1).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	static int getLowerIdx(long k, long[] A) {
		
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] >= k) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	static int getUpperIdx(long k, long[] A) {
		
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			
			int mid = (left + right) / 2;
			if(A[mid] > k) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return right;
	}
}
