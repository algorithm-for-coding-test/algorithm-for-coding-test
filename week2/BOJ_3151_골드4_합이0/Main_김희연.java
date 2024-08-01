package week2.BOJ_3151_골드4_합이0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] cnt = new int[20001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]+10000]++;
		}

		long answer = 0l;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int sum = arr[i]+arr[j];
				if (Math.abs(sum) > 10000) continue;

				answer += cnt[-sum+10000]; // 두 명의 합 sum에 대해서 0이 되기 위해 -sum
				// 중복 카운트 방지
				if (-sum==arr[i]) answer--;
				if (-sum==arr[j]) answer--;
			}
		}

		System.out.println(answer/3); //각 팀이 세 번씩 중복 카운트되었으므로 3으로 나눔
	}
}
