package week11_2.BOJ_1460_골드3_진욱이의농장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int n, m;
	static int[][] farm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		farm = new int[n][n];

		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());


			for (int i = x; i < x + l; i++) {
				for (int j = y; j < y + l; j++) {
					farm[i][j] = f;
				}
			}
		}

		int result = 0;

		// 과일 두 종류에 대해 최대 정사각형 크기 계산
		for (int i = 1; i < 8; i++) {
			for (int j = i + 1; j < 8; j++) {
				result = Math.max(result, search(i, j));
			}
		}

		System.out.println(result * result);
	}

	public static int search(int target1, int target2) {
		int[][] dp = new int[n][n];

		//넓이를 구하기 위해 과일 두 종류 위치에 1로 표시 해놓기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (farm[i][j] == target1 || farm[i][j] == target2) {
					dp[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (dp[i][j] != 0) { //최대 정사각형 넓이 구하는 법
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
