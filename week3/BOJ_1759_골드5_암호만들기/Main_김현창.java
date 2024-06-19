package week3.BOJ_1759_골드5_암호만들기;

import java.io.*;
import java.util.*;

public class Main_김현창 {

	private static int L, C;
	private static char[] alphabet;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		alphabet = new char[C];
		for (int i = 0; i < C; ++i) {
			alphabet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alphabet);
		dfs(0, 0, 0, new StringBuilder());
	    br.close();
	}

	private static void dfs(int index, int mo, int ja, StringBuilder sb) {
		if (mo + ja == L) {
			if (mo >= 1 && ja >= 2) {
				System.out.println(sb.toString());
			}
			return;
		}
		for (int i = index; i < C; ++i) {
			sb.append(alphabet[i]);
			switch (alphabet[i]) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					dfs(i + 1, mo + 1, ja, sb);
					break;
				default:
					dfs(i + 1, mo, ja + 1, sb);
			}
			sb.setLength(sb.length() - 1);
		}
	}
}
