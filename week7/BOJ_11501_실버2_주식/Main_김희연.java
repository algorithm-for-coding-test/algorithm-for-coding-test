package week7.BOJ_11501_실버2_주식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			long answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[j] = Integer.parseInt(st.nextToken());

			int max = arr[n-1];    //마지막 값으로 설정
			for (int j = n-2; j >= 0; j--) {
				if (arr[j] <= max)    //가장 큰 시세보다 작은 시세일 때 판매
					answer += max - arr[j];
				else
					max = arr[j];
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
