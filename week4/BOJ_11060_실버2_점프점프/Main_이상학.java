package week4.BOJ_11060_실버2_점프점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//java8 1등, java11 1등
public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sumArray = new int[N];
		for(int i=1; i<N; i++) {
			sumArray[i] = 1001;
		}
		sumArray[0] = 0;
		for(int i=0; i<N; i++) {
			
			for(int j=i+1; j<=array[i]+i; j++) {
				
				if(j == N) {
					break;
				}
				if(sumArray[j] > sumArray[i]) {
					sumArray[j] = sumArray[i] + 1;					
				}
			}
		}
		
		if(sumArray[N-1] == 1001) {
			sumArray[N-1] = -1;
		}
		
		System.out.println(sumArray[N-1]);
	}
}
