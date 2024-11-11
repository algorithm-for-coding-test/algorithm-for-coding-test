package week12_2.BOJ_1672_브론즈1_DNA해독;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] A = br.readLine().toCharArray();
		for (int i = N - 1; i > 0; --i) {
			A[i - 1] = decode(A[i - 1], A[i]);
		}
		System.out.println(A[0]);
		br.close();
	}

	private static char decode(char a, char b) {
		if (a == b) return a;
		if (a == 'A') {
			if (b == 'G') return 'C';
			if (b == 'C') return 'A';
			if (b == 'T') return 'G';
		} else if (a == 'G') {
			if (b == 'A') return 'C';
			if (b == 'C') return 'T';
			if (b == 'T') return 'A';
		} else if (a == 'C') {
			if (b == 'A') return 'A';
			if (b == 'G') return 'T';
			if (b == 'T') return 'G';
		} else if (a == 'T') {
			if (b == 'A') return 'G';
			if (b == 'G') return 'A';
			if (b == 'C') return 'G';
		}
		throw new IllegalArgumentException();
	}
}