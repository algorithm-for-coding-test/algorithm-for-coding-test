package week2.BOJ_11660_실버1_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			int sum = 0;
			for(int j=y1; j<=y2; j++) {
				sum += map[j][x2] - map[j][x1-1];
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
