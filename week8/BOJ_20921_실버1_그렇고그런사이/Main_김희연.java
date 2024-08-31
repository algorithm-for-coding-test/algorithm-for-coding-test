package week8.BOJ_20921_실버1_그렇고그런사이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int sum = 0;
		int index = n;
		boolean[] select = new boolean[n+1];

		while (index > 0) {
			if (sum + index-1 <= k) {
				sum += index-1; //왼쪽 > 오른쪽 인 개수
				select[index] = true;
			}
			index--;
		}

		for (int i = n; i > 0; i--) {
			if (select[i]) {
				sb.append(i).append(" ");
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!select[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}
