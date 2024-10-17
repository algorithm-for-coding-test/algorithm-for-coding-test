package week12_2.BOJ_1672_브론즈1_DNA해독;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_김희연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		char[][] agct = new char[][]{
			{'A', 'C', 'A', 'G'},
			{'C', 'G', 'T', 'A'},
			{'A', 'T', 'C', 'G'},
			{'G', 'A', 'G', 'T'}
		};

		char[] arr = str.toCharArray();
		for(int i=0; i<n-1; i++){
			int a = (n-1)-(i+1);
			int b = (n-1)-(i);
			arr[a] = agct[index(arr[a])][index(arr[b])];
		}

		System.out.println(arr[0]);
	}

	public static int index(char c) {
		switch (c) {
			case 'A':
				return 0;
			case 'G':
				return 1;
			case 'C':
				return 2;
			default:
				return 3;
		}
	}
}
