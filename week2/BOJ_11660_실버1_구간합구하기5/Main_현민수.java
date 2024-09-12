package week2.BOJ_11660_실버1_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_현민수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine()," ");
			for(int j=1;j<=N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
			{
				sum[i][j]=map[i][j]+sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1];
			}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine()," ");
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			System.out.println(sum[endY][endX]-sum[endY][startX-1]-sum[startY-1][endX]+sum[startY-1][startX-1]);
		}
				
		
	}

}