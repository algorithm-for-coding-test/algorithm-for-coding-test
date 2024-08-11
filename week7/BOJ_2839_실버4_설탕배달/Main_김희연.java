package week7.BOJ_2839_실버4_설탕배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_김희연 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt;
		int min = N;

		for(int i=0; i<=N/5; i++) {
			for(int j=0; j<=N/3; j++) {
				if((5*i + 3*j)==N) {
					cnt = i+j;
					min = Math.min(min, cnt);
				}
			}
		}

		if(min == N)
			min = -1;
		System.out.println(min);
	}
}
