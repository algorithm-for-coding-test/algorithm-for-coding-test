package week4.BOJ_17216_실버2_가장큰감소부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// java8 1등, java11 1등
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
		
		int result = array[0];
		int[] sumArray = new int[N];
		sumArray[0] = array[0];
		for(int i=1; i<N; i++) {
			
			int biggest = 0;
			for(int j=i-1; j>=0; j--) {
				
				if(array[i] < array[j]) {
					if(biggest < sumArray[j]) {
						biggest = sumArray[j];
					}
				}
			}
			
			sumArray[i] = biggest + array[i];
			
			result = Math.max(result, sumArray[i]);
		}
		
		System.out.println(result);
	}
}
