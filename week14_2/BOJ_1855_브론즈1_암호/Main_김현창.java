package week14_2.BOJ_1855_브론즈1_암호;

import java.io.*;

public class Main_김현창 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int length = str.length();

		char[][] table = new char[length / K][K];
		for (int i = 0, index = 0; i < length / K; ++i) {
			for (int j = 0; j < K; ++j) {
				int _j = (i % 2 == 0) ? j : K - j - 1;
				table[i][_j] = str.charAt(index++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < K; ++j) {
			for (int i = 0; i < length / K; ++i) {
				sb.append(table[i][j]);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
