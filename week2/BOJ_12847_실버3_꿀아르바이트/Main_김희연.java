package week2.BOJ_12847_실버3_꿀아르바이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n,m;
	static Long[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new Long[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]= Long.parseLong(st.nextToken());
		}

		long sum =0;
		for(int i=0; i<m; i++){
			sum += arr[i];
		}

		long max = sum;
		for(int j=m; j<n; j++) {
			sum += arr[j] - arr[j-m];
			max=Math.max(max, sum);
		}

		System.out.println(max);
	}
}