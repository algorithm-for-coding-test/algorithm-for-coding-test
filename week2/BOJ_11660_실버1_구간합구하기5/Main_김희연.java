package week2.BOJ_11660_실버1_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_김희연 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];

		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
			}
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
			sb.append(result + "\n");
		}

		System.out.println(sb);
	}
}