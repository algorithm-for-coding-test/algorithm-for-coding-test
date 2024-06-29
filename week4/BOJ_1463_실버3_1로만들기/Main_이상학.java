package week4.BOJ_1463_실버3_1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이상학 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N+5];
		array[0] = 0;
		array[1] = 0;
		array[2] = 1;
		array[3] = 1;
		array[4] = 2;
		array[5] = 3;
		for(int i=6; i<=N; i++) {
			
			if(i%6 == 0) {
				array[i] = Math.min(Math.min(array[i/2], array[i/3]), array[i-1]) + 1;
			}
			else if(i%3 == 0) {
				array[i] = Math.min(array[i/3], array[i-1]) + 1;
			}
			else if(i%2 == 0) {
				array[i] = Math.min(array[i/2], array[i-1]) + 1;
			}
			else {
				array[i] = array[i-1] + 1;
			}
		}
		
		System.out.println(array[N]);
	}
}
