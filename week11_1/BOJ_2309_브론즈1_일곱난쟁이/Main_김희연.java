package week11_1.BOJ_2309_브론즈1_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_김희연 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[9];

		int sum = 0;
		for(int i=0; i<9; i++){
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		outerLoop:
		for(int i=0; i<8; i++){
			for(int j=i+1; j<9; j++){
				if(sum - arr[i] - arr[j] == 100){
					arr[i] = 101;
					arr[j] = 101;

					break outerLoop;
				}
			}
		}

		Arrays.sort(arr);

		for(int i=0; i<7; i++){
			sb.append(arr[i]).append("\n");
		}

		System.out.println(sb);
	}
}
