package week12_1.BOJ_28417_브론즈3_스케이트보드;

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

		int max = 0;
		for(int i=0; i<n; i++){
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum = Math.max(a, b);

			int[] trick = new int[5];
			for(int j=0; j<5; j++){
				trick[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(trick);

			sum += (trick[3] + trick[4]);

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
