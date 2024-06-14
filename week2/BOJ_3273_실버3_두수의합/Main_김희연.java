package week2.BOJ_3273_실버3_두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int cnt = 0;
		int sum = 0;
		int start = 0;
		int end = n-1;

		while(start < end){
			sum = arr[start] + arr[end];

			if(sum == x)
				cnt++;

			if(sum < x)
				start++;
			else
				end--;
		}

		System.out.println(cnt);
	}
}
