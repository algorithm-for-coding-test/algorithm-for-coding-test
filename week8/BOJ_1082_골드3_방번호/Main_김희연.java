package week8.BOJ_1082_골드3_방번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 자릿수 가장 길게 만들기
 * 2. 맨 앞자리부터 가장 큰 수 만들기
 */

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] cost = new int[n];
		int min = 50;
		int index = -1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());

			if (min >= cost[i]) { // 비용이 가장 작으면서 값이 큰 숫자 찾기
				min = cost[i];
				index = i;
			}
		}

		int money = Integer.parseInt(br.readLine());
		int[] num = new int[51];
		int cnt = 0;
		while (money >= min) { // 1. 자리수 최대한 길게 늘리기
			num[cnt++] = index;
			money -= min;
		}

		int start = 0; // 자릿수 시작 위치
		for (int i = 0; i < cnt; i++) { // 2. 맨 앞자리부터 가장 큰 수 만들기
			for (int j = n - 1; j >= 0; j--) {
				if (cost[j] <= money + min) {
					num[i] = j;
					money += min - cost[j];
					break;
				}
			}

			if (num[start] == 0) { 	// 맨 앞의 값이 0이라면 더 큰 숫자를 살 수 없다는 뜻
				start++; 			//자릿수 한 개 반납
				money += min;		//그만큼 돈을 돌려받음
			}
		}

		if (start == cnt) { //cnt 크기까지 왔다는 것은 앞이 모두 0이였다는 뜻
			System.out.println(0);
			return;
		}

		for (int i = start; i < cnt; i++) {
			sb.append(num[i]);
		}

		System.out.println(sb);
	}
}
