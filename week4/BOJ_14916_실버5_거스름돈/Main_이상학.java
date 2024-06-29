package week4.BOJ_14916_실버5_거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// java8 1등, java11 1등
public class Main_이상학 {
	
	static int moneyCount = 0;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		getLessMoneyCount(n);
		
		System.out.println(moneyCount);
	}
	
	static void getLessMoneyCount(int n) {
		
		if(n < 5 && n%2 == 1) {
			moneyCount = -1;
			return;
		}
		
		if((n % 5) % 2 == 1) {
			moneyCount += (n/5)-1;
			n -= ((n/5) - 1) * 5;
			moneyCount += (n/2);
			n -= (n/2) * 2;
		}
		else {
			moneyCount += n/5;
			n -= (n/5) * 5;
			moneyCount += n/2;
			n -= (n/2) * 2;
		}
		
		if(n != 0) {
			moneyCount = -1;
		}
	}
}

//DP 풀이

//public static void main(String[] args) throws IOException {
//	
//	
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//	int n = Integer.parseInt(br.readLine());
//	
//	int[] arr = new int[n+5];
//	
//	arr[0] = -1;
//	arr[1] = -1;
//	arr[2] = 1;
//	arr[3] = -1;
//	arr[4] = 2;
//	arr[5] = 1;
//	for(int i=6; i<n+1; i++) {
//		
//		if(arr[i-2] == -1) {
//			arr[i] = arr[i-5] + 1;				
//		}
//		else if(arr[i-5] == -1) {
//			arr[i] = arr[i-2] + 1;
//		}
//		else if(arr[i-2] != -1 && arr[i-5] != -1) {
//			arr[i] = Math.min(arr[i-2], arr[i-5]) + 1;
//		}
//	}
//	
//	System.out.println(arr[n]);
//}
