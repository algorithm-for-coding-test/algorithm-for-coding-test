package week2.BOJ_2559_실버3_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] temperatureList = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			temperatureList[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += temperatureList[i];
		}
		
		int max = sum;
		for(int i=0; i+K<N; i++) {
			
			sum -= temperatureList[i];
			sum += temperatureList[i+K];
			if(max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
