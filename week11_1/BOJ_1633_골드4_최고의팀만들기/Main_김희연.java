package week11_1.BOJ_1633_골드4_최고의팀만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	static int[] white;
	static int[] black;
	static int n;
	static int answer;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		white = new int[1000];
		black = new int[1000];
		String str;
		int i = 0;
		while((str = br.readLine()) != null && !str.isEmpty()){
			st = new StringTokenizer(str);
			white[i] = Integer.parseInt(st.nextToken());
			black[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		n = i;

		dp = new int[1000][16][16];

		System.out.println(dfs(0, 0, 0));
	}

	/**dp 적용 안했을 경우**/
	/*
	public static int dfs(int index, int wCnt, int bCnt){
		if(wCnt == 15 && bCnt == 15)
			return 0;
		if(index == n)
			return 0;

		//흑,백 선택안했을 경우
		answer = dfs(index+1, wCnt, bCnt);

		//백 선택
		if(wCnt < 15)
		answer = Math.max(answer, dfs(index+1, wCnt+1, bCnt) + white[index]);

		//흑 선택
		if(bCnt < 15)
		answer = Math.max(answer, dfs(index+1, wCnt, bCnt+1) + black[index]);

		return answer;
	}
	 */

	/**dp 적용 했을 경우**/
	public static int dfs(int index, int wCnt, int bCnt){
		if(wCnt == 15 && bCnt == 15)
			return 0;
		if(index == n)
			return 0;

		if(dp[index][wCnt][bCnt] != 0)
			return dp[index][wCnt][bCnt];

		dp[index][wCnt][bCnt] = dfs(index+1, wCnt, bCnt);

		if(wCnt < 15)
			dp[index][wCnt][bCnt] = Math.max(dp[index][wCnt][bCnt], dfs(index+1, wCnt+1, bCnt) + white[index]);

		if(bCnt < 15)
			dp[index][wCnt][bCnt] = Math.max(dp[index][wCnt][bCnt], dfs(index+1, wCnt, bCnt+1) + black[index]);

		return dp[index][wCnt][bCnt];
	}
}
