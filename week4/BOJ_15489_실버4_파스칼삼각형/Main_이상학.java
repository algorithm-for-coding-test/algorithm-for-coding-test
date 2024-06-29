package week4.BOJ_15489_실버4_파스칼삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//java8 1등, java11 1등
public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[31][31];
		for(int i=1; i<31; i++) {
			for(int j=1; j<=i; j++) {
				if(j == 1 || j == i) {
					array[i][j] = 1;
				}
				else {
					array[i][j] = array[i-1][j-1] + array[i-1][j];
				}
			}
		}
		
		int sum = 0;
		for(int i=R; i<R+W; i++) {
			for(int j=C; j<=C+i-R; j++) {
				sum += array[i][j];
			}
		}
		
		System.out.println(sum);
	}
}
