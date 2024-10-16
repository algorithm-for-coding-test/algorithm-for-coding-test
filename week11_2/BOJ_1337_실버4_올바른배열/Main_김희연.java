package week11_2.BOJ_1337_실버4_올바른배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int answer = 0;
		for(int i=0; i<n; i++){
			int cnt = 1;
			int max = arr[i] + 4;

			for(int j=i+1; j<i+5; j++){
				if(j >= n)
					break;
				if(arr[j] <= max)
					cnt++;
			}

			answer = Math.max(answer, cnt);
		}

		System.out.println(5-answer);
	}
}
