package week4.BOJ_2294_골드5_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //동전의 종류
		int k = Integer.parseInt(st.nextToken()); //동전의 가치의 합

		int[] arr = new int[n+1]; //동전의 가치
		int[] dp = new int[k+1];  //사용한 동전의 최소 개수

		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=1; i<=k; i++){
			dp[i] = 10001;
		}

		for(int i=1; i<=n; i++){
			for(int j=arr[i]; j<=k; j++){
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			}
		}

		if(dp[k] == 10001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}