package week4.BOJ_16493_실버2_최대페이지수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {
	
	static boolean[] visit;
	static int N, M;
	static int maxResult = 0;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M][2];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[M];
		
		powerSet(0);
		
		System.out.println(maxResult);
	}
	
	static void powerSet(int depth) {
		
		if(depth == M) {
			
			int pageSum = 0;
			int daySum = 0;
			for(int i=0; i<M; i++) {
				
				if(visit[i]) {
					daySum += array[i][0];
					if(daySum > N) {
						return;
					}
					pageSum += array[i][1];
				}
			}
			
			maxResult = Math.max(maxResult, pageSum);
			return;
		}
		
		visit[depth] = false;
		powerSet(depth+1);
		
		visit[depth] = true;
		powerSet(depth+1);
	}
}
