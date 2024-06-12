package week2.BOJ_11659_실버3_구간합구하기4;

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
		
		int[] sumList = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i=1; i<N+1; i++) {
			num = Integer.parseInt(st.nextToken());
			sumList[i] = num + sumList[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		int a = 0;
		int b = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(sumList[b] - sumList[a-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
